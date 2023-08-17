package com.johnvazna.core.bases

import com.johnvazna.core.extensions.lifecycle.Result

/** */
abstract class BaseUseCase<Source, Params, Output> {

    abstract val source: Source

    abstract suspend fun execute(params: Params): Result<Output>

    open suspend fun execute(): Result<Output> = execute(Unit as Params)

    protected inline fun <T, R> Result<T>.mapResource(transform: (T) -> R): Result<R> {
        return when (this) {
            is Result.Success -> Result.Success(data = transform(data))
            is Result.Error -> Result.Error(error)
        }
    }
}
