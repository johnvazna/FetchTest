package com.johnvazna.network.hiring.di

import com.johnvazna.network.hiring.HiringService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

/** */
@Module
@InstallIn(SingletonComponent::class)
object HiringServiceModule {

    @Provides
    fun provideProjectsService(retrofit: Retrofit): HiringService {
        return retrofit.create(HiringService::class.java)
    }
}
