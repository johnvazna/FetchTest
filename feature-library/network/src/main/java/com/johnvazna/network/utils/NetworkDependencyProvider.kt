package com.johnvazna.network.utils

import retrofit2.Retrofit

/** */
interface NetworkDependencyProvider {

    fun providerRetrofit(): Retrofit
}
