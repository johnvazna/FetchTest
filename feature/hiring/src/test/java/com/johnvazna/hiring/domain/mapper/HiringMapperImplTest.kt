package com.johnvazna.hiring.domain.mapper

import com.johnvazna.hiring.domain.entities.Person
import com.johnvazna.hiring.presentation.entities.PersonUI
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

/** */
class HiringMapperImplTest {

    private lateinit var mapper: HiringMapperImpl

    @Before
    fun setUp() {
        mapper = HiringMapperImpl()
    }

    @Test
    fun `test transformPersonInformationDomainToUI maps correctly`() = runBlocking {
        // Given
        val mockPersonList = listOf(
            Person(1, 100, "John"),
            Person(2, 101, "Jane")
        )

        val expectedPersonUIList = listOf(
            PersonUI(1, 100, "John"),
            PersonUI(2, 101, "Jane")
        )

        // When
        val result = mapper.transformPersonInformationDomainToUI(mockPersonList)

        // Then
        assertEquals(expectedPersonUIList, result)
    }
}
