package com.johnvazna.hiring.domain.mapper

import com.johnvazna.hiring.domain.entities.Person
import com.johnvazna.hiring.presentation.entities.PersonUI
import javax.inject.Inject

/** */
class HiringMapperImpl @Inject constructor() : HiringMapper {

    override suspend fun transformPersonInformationDomainToUI(params: List<Person>) =
        params.map {
            PersonUI(
                it.id,
                it.listId,
                it.name
            )
        }
}
