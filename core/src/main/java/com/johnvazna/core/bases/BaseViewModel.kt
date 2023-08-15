package com.johnvazna.core.bases

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.johnvazna.core.extensions.exception.ErrorPresentation
import com.johnvazna.core.extensions.exception.toPresentation
import com.johnvazna.core.extensions.lifecycle.Event
import com.johnvazna.core.extensions.lifecycle.Result
import com.johnvazna.core.extensions.lifecycle.launch
import com.johnvazna.core.extensions.lifecycle.onResult
import com.johnvazna.core.extensions.lifecycle.throttleFirst
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.delay

/** */
abstract class BaseViewModel : ViewModel() {

    private val _onError = MutableLiveData<Event<ErrorPresentation>>()
    val onError: LiveData<Event<ErrorPresentation>> get() = _onError

    private val _showLoadingDialog = MutableLiveData<Event<Boolean>>()
    val showLoadingDialog: LiveData<Event<Boolean>> = _showLoadingDialog

    private val debounceError = throttleFirst<Exception>(
        10000L,
        coroutineScope = viewModelScope
    ) {
        _onError.postValue(Event(it.toPresentation()))
    }

    private fun showLoading() {
        _showLoadingDialog.postValue(Event(true))
    }

    private fun hideLoading() {
        _showLoadingDialog.postValue(Event(false))
    }

    fun onError(error: Exception) {
        debounceError(error)
    }

    private fun onResponse(vararg block: suspend () -> Unit) {
        showLoading()
        launch {
            block.map {
                async {
                    delay(2000)
                    it()
                }
            }.awaitAll()
            hideLoading()
        }
    }

    protected fun getResponse(block: suspend () -> Unit) {
        onResponse({ block() })
    }

    protected fun <T> Result<T>.onResultArrive(
        onSuccess: (data: T) -> Unit
    ) = onResult(
        onSuccess,
        ::onError
    )
}
