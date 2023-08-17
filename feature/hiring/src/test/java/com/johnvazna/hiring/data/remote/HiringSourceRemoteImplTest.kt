package com.johnvazna.hiring.data.remote

import com.johnvazna.network.hiring.HiringService
import com.johnvazna.network.hiring.entities.PersonResponse
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

/** */
class HiringSourceRemoteImplTest {

    private lateinit var remoteImpl: HiringSourceRemoteImpl
    private val service: HiringService = mockk()

    @Before
    fun setUp() {
        remoteImpl = HiringSourceRemoteImpl(service)
    }

    @Test
    fun `test getHiringPersons calls service getHiring`() = runBlocking {
        // Given
        val mockResponse: List<PersonResponse> = mockk()
        coEvery { service.getHiring() } returns mockResponse

        // When
        remoteImpl.getHiringPersons()

        // Then
        coVerify { service.getHiring() }
    }
}
