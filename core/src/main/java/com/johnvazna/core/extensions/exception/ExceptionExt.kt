package com.johnvazna.core.extensions.exception

/** */
fun Exception.toPresentation() = when (this) {
    is ErrorEntity.TimeOut -> ErrorPresentation.TimeOut
    is ErrorEntity.Network -> ErrorPresentation.NoInternet
    is ErrorEntity.ServiceError -> ErrorPresentation.CustomError(errorCode)

    else -> ErrorPresentation.Generic
}

fun Exception.toDomain() = when (this) {
    is ErrorSource.Network -> ErrorEntity.Network
    is ErrorSource.TimeOut -> ErrorEntity.TimeOut
    is ErrorSource.ServiceError -> ErrorEntity.ServiceError(errorCode)

    else -> ErrorSource.Generic
}
