package com.johnvazna.core.bases

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.viewbinding.ViewBinding
import com.johnvazna.core.extensions.lifecycle.Event
import com.johnvazna.core.extensions.lifecycle.EventObserver

/** */
abstract class BaseFragment<T : ViewBinding, VM : BaseViewModel> : Fragment() {

    private var _binding: T? = null
    val binding get() = _binding!!

    private val baseLoading: BaseLoading by lazy { BaseLoading() }

    protected abstract val viewModel: VM

    fun <DB : ViewDataBinding> DB.bindLayout(bind: DB.() -> Unit) = bind(this).let {
        lifecycleOwner = viewLifecycleOwner
        root
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = setupBinding(inflater, container)
        return binding.root
    }

    abstract fun setupBinding(inflater: LayoutInflater, container: ViewGroup?): T

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun <T> LiveData<Event<T>>.observeEvent(cb: (T) -> Unit) {
        observe(viewLifecycleOwner, EventObserver(cb))
    }

    fun showLoading() = baseLoading.showDialog(context, false)

    fun hideLoading() = baseLoading.hideDialog()
}
