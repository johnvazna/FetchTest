package com.johnvazna.core.extensions.exception

/** */
interface ErrorHandler {

    suspend fun getError(throwable: Throwable): ErrorSource
}
