package com.johnvazna.hiring.domain.mapper

import com.johnvazna.hiring.domain.entities.Person
import com.johnvazna.hiring.presentation.entities.PersonUI

/** */
interface HiringMapper {

    suspend fun transformPersonInformationDomainToUI(params: List<Person>): List<PersonUI>
}
