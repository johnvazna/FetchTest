package com.johnvazna.hiring.presentation.viewmodel

import com.johnvazna.core.extensions.lifecycle.Result
import com.johnvazna.hiring.domain.usescases.GetHiringPersonsUseCase
import com.johnvazna.hiring.presentation.entities.PersonUI
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

/** */
class HiringViewModelTest {

    private lateinit var viewModel: HiringViewModel
    private val getHiringPersonsUseCase: GetHiringPersonsUseCase = mockk(relaxed = true)

    @Before
    fun setUp() {
        viewModel = HiringViewModel(getHiringPersonsUseCase)
    }

    @Test
    fun `test init calls useCase and updates personsState`() = runBlocking {
        // Given
        val mockPersonUIList: List<PersonUI> = listOf(mockk(), mockk())
        coEvery { getHiringPersonsUseCase.execute() } returns Result.Success(mockPersonUIList)

        // Initialize ViewModel within coroutine context
        viewModel = HiringViewModel(getHiringPersonsUseCase)

        // Then
        coVerify { getHiringPersonsUseCase.execute() } // Use coVerify for suspending functions
        assertEquals(mockPersonUIList, viewModel.personsState.value)
    }
}
