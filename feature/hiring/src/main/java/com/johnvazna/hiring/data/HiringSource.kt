package com.johnvazna.hiring.data

import com.johnvazna.core.extensions.lifecycle.Result
import com.johnvazna.hiring.domain.entities.Person

/** */
interface HiringSource {

    suspend fun getHiringPersons(): Result<List<Person>>
}
