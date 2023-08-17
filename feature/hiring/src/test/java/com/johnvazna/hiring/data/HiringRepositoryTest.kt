package com.johnvazna.hiring.data

import com.johnvazna.core.extensions.lifecycle.Result
import com.johnvazna.hiring.data.mapper.HiringSourceMapper
import com.johnvazna.hiring.data.remote.HiringSourceRemote
import com.johnvazna.hiring.domain.entities.Person
import com.johnvazna.network.hiring.entities.PersonResponse
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

/** */
class HiringRepositoryTest {

    private lateinit var repository: HiringRepository
    private val remote: HiringSourceRemote = mockk()
    private val mapper: HiringSourceMapper = mockk()

    @Before
    fun setUp() {
        repository = HiringRepository(remote, mapper)
    }

    @Test
    fun `test getHiringPersons returns mapped data`() = runBlocking {
        // Given
        val mockResponse: List<PersonResponse> =
            mockk()
        val mockPersonList: List<Person> = listOf(mockk(), mockk())

        coEvery { remote.getHiringPersons() } returns Result.Success(
            mockResponse
        )
        coEvery { mapper.transformHiringResponseToDomain(mockResponse) } returns mockPersonList

        // When
        val result = repository.getHiringPersons()

        // Then
        coVerify { mapper.transformHiringResponseToDomain(mockResponse) }
        assertEquals(Result.Success(mockPersonList), result)
    }
}
