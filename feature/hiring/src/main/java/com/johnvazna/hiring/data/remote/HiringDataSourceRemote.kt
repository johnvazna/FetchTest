package com.johnvazna.hiring.data.remote

import com.johnvazna.core.extensions.lifecycle.Result
import com.johnvazna.network.hiring.entities.PersonResponse

/** */
interface HiringDataSourceRemote {

    suspend fun getHiringPersons(): Result<List<PersonResponse>>
}
