package com.johnvazna.hiring.domain.usecases

import com.johnvazna.core.extensions.lifecycle.Result
import com.johnvazna.hiring.data.HiringSource
import com.johnvazna.hiring.domain.entities.Person
import com.johnvazna.hiring.domain.mapper.HiringMapper
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
class GetHiringPersonsUseCaseTest {

    private lateinit var useCase: GetHiringPersonsUseCase
    private val source: HiringSource = mockk()
    private val mapper: HiringMapper = mockk()

    @Before
    fun setUp() {
        useCase = GetHiringPersonsUseCase(source, mapper)
    }

    @Test
    fun `test execute calls source and mapper correctly`() = runBlocking {
        // Given
        val mockPersonList: List<Person> = listOf(mockk(), mockk())
        val mockPersonUIList: List<PersonUI> = listOf(mockk(), mockk())

        coEvery { source.getHiringPersons() } returns Result.Success(mockPersonList)
        coEvery { mapper.transformPersonInformationDomainToUI(mockPersonList) } returns mockPersonUIList

        // When
        val result = useCase.execute(Unit)

        // Then
        coVerify { source.getHiringPersons() }
        coVerify { mapper.transformPersonInformationDomainToUI(mockPersonList) }
        assertEquals(Result.Success(mockPersonUIList), result)
    }
}
