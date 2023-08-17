package com.johnvazna.hiring.data.mapper

import com.johnvazna.hiring.domain.entities.Person
import com.johnvazna.network.hiring.entities.PersonResponse
import javax.inject.Inject

/** */
class HiringSourceMapperImpl @Inject constructor() : HiringSourceMapper {

    override suspend fun transformHiringResponseToDomain(params: List<PersonResponse>) =
        params.map {
            Person(
                it.id,
                it.listId,
                it.name
            )
        }
}
