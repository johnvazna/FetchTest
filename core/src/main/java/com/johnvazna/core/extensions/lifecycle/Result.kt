package com.johnvazna.core.extensions.lifecycle

/** */
sealed class Result<out T> {
    data class Success<out T>(val data: T) : Result<T>()
    data class Error(val error: Exception) : Result<Nothing>()
}

val Result<*>.isSuccess
    get() = this is Result.Success

fun <T> Result<T>.onResult(onSuccess: (data: T) -> Unit, onError: (Exception) -> Unit) =
    when {
        isSuccess -> onSuccess(getData())
        else -> onError(getError())
    }

fun <T> Result<T>.getData() = (this as Result.Success).data

fun <T> Result<T>.getError() = (this as Result.Error).error

suspend fun <T, R> Result<T>.mapDataSuspend(transform: suspend (T) -> R): Result<R> {
    return when (this) {
        is Result.Success -> {
            try {
                Result.Success(data = transform(data))
            } catch (e: Exception) {
                Result.Error(e)
            }
        }

        is Result.Error -> this
    }
}
