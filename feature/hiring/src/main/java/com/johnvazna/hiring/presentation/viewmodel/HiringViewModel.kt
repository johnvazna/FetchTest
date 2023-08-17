package com.johnvazna.hiring.presentation.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.johnvazna.core.bases.BaseViewModel
import com.johnvazna.hiring.domain.usescases.GetHiringPersonsUseCase
import com.johnvazna.hiring.presentation.entities.PersonUI
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/** */
@HiltViewModel
class HiringViewModel @Inject constructor(
    private val getHiringPersonsUseCase: GetHiringPersonsUseCase
) : BaseViewModel() {

    val personsState: MutableState<List<PersonUI>> = mutableStateOf(listOf())

    init {
        getResponse {
            getHiringPersonsUseCase.execute().onResultArrive { result ->
                personsState.value = result
            }
        }
    }
}
