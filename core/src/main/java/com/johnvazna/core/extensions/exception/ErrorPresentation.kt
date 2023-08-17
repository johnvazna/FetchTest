package com.johnvazna.core.extensions.exception

/** */
sealed class ErrorPresentation {

    object Generic : ErrorPresentation()

    object TimeOut : ErrorPresentation()

    object NoInternet : ErrorPresentation()

    data class CustomError(
        val errorCode: String
    ) : ErrorPresentation()
}
