package com.johnvazna.network.hiring

import com.johnvazna.network.hiring.entities.PersonResponse
import retrofit2.http.GET

/** */
interface HiringService {

    @GET("hiring.json")
    suspend fun getHiring(): List<PersonResponse>
}
