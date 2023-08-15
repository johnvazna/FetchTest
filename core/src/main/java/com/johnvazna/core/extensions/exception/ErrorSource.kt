package com.johnvazna.core.extensions.exception

/** */
sealed class ErrorSource : Exception() {

    object Network : ErrorSource()

    object TimeOut : ErrorSource()

    data class ServiceError(
        val errorCode: String
    ) : ErrorSource()

    object Generic : ErrorSource()
}
