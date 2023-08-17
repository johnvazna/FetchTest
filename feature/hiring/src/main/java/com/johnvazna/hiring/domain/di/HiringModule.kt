package com.johnvazna.hiring.domain.di

import com.johnvazna.hiring.domain.mapper.HiringMapper
import com.johnvazna.hiring.domain.mapper.HiringMapperImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/** */
@Module
@InstallIn(SingletonComponent::class)
abstract class HiringModule {

    @Binds
    abstract fun bindHiringMapper(mapper: HiringMapperImpl): HiringMapper
}
