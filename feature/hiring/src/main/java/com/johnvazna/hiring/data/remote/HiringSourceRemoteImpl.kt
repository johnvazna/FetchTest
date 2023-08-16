package com.johnvazna.hiring.data.remote

import com.johnvazna.core.bases.BaseRemoteDataSource
import com.johnvazna.network.hiring.HiringService
import javax.inject.Inject

/** */
class HiringSourceRemoteImpl @Inject constructor(
    private val service: HiringService
) : HiringSourceRemote, BaseRemoteDataSource() {

    override suspend fun getHiringPersons() =
        getResult { service.getHiring() }
}
