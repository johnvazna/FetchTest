package com.johnvazna.core.extensions.exception

/** */
sealed class ErrorEntity : Exception() {

    object Network : ErrorEntity()

    object TimeOut : ErrorEntity()

    data class ServiceError(
        val errorCode: String
    ) : ErrorEntity()
}
