package com.johnvazna.hiring.domain.usescases

import com.johnvazna.core.bases.BaseUseCase
import com.johnvazna.core.extensions.lifecycle.mapDataSuspend
import com.johnvazna.hiring.data.HiringSource
import com.johnvazna.hiring.domain.mapper.HiringMapper
import com.johnvazna.hiring.presentation.entities.PersonUI
import javax.inject.Inject

/** */
class GetHiringPersonsUseCase @Inject constructor(
    override val source: HiringSource,
    private val mapper: HiringMapper
) : BaseUseCase<HiringSource, Unit, List<PersonUI>>() {

    override suspend fun execute(params: Unit) =
        source.getHiringPersons().mapDataSuspend { data ->
            mapper.transformPersonInformationDomainToUI(data)
        }
}
