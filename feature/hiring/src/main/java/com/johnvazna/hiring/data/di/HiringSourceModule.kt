package com.johnvazna.hiring.data.di

import com.johnvazna.hiring.data.HiringRepository
import com.johnvazna.hiring.data.HiringSource
import com.johnvazna.hiring.data.mapper.HiringSourceMapper
import com.johnvazna.hiring.data.mapper.HiringSourceMapperImpl
import com.johnvazna.hiring.data.remote.HiringSourceRemote
import com.johnvazna.hiring.data.remote.HiringSourceRemoteImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/** */
@Module
@InstallIn(SingletonComponent::class)
abstract class HiringSourceModule {

    @Binds
    abstract fun bindHiringSource(repository: HiringRepository): HiringSource

    @Binds
    abstract fun bindHiringSourceRemote(remote: HiringSourceRemoteImpl): HiringSourceRemote

    @Binds
    abstract fun bindHiringSourceMapper(mapper: HiringSourceMapperImpl): HiringSourceMapper
}
