package com.johnvazna.hiring.data

import com.johnvazna.core.extensions.lifecycle.Result
import com.johnvazna.core.extensions.lifecycle.mapDataSuspend
import com.johnvazna.hiring.data.mapper.HiringSourceMapper
import com.johnvazna.hiring.data.remote.HiringSourceRemote
import com.johnvazna.hiring.domain.entities.Person
import javax.inject.Inject

/** */
class HiringRepository @Inject constructor(
    private val remote: HiringSourceRemote,
    private val mapper: HiringSourceMapper
) : HiringSource {

    override suspend fun getHiringPersons(): Result<List<Person>> {
        return remote.getHiringPersons().mapDataSuspend { response ->
            mapper.transformHiringResponseToDomain(response)
        }
    }
}
