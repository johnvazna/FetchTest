package com.johnvazna.hiring.data.mapper

import com.johnvazna.hiring.domain.entities.Person
import com.johnvazna.network.hiring.entities.PersonResponse

/** */
interface HiringSourceMapper {

    suspend fun transformHiringResponseToDomain(params: List<PersonResponse>): List<Person>
}
