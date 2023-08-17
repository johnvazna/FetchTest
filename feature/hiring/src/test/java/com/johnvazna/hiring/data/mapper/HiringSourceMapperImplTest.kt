package com.johnvazna.hiring.data.mapper

import com.johnvazna.hiring.domain.entities.Person
import com.johnvazna.network.hiring.entities.PersonResponse
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

/** */
class HiringSourceMapperImplTest {

    private lateinit var mapper: HiringSourceMapperImpl

    @Before
    fun setUp() {
        mapper = HiringSourceMapperImpl()
    }

    @Test
    fun `test transformHiringResponseToDomain maps correctly`() = runBlocking {
        // Given
        val mockPersonResponseList = listOf(
            PersonResponse(1, 100, "John"),
            PersonResponse(2, 101, "Jane")
        )

        val expectedPersonList = listOf(
            Person(1, 100, "John"),
            Person(2, 101, "Jane")
        )

        // When
        val result = mapper.transformHiringResponseToDomain(mockPersonResponseList)

        // Then
        assertEquals(expectedPersonList, result)
    }
}
