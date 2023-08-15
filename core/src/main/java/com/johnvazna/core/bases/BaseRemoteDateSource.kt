package com.johnvazna.core.bases

import com.google.gson.Gson
import com.google.gson.JsonParseException
import com.johnvazna.core.extensions.exception.ErrorHandler
import com.johnvazna.core.extensions.exception.ErrorNetwork
import com.johnvazna.core.extensions.exception.ErrorSource
import com.johnvazna.core.extensions.exception.toDomain
import com.johnvazna.core.extensions.lifecycle.Result
import com.johnvazna.core.extensions.utils.emptyString
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import retrofit2.HttpException
import java.io.IOException
import java.net.SocketTimeoutException

/** */
abstract class BaseRemoteDataSource : ErrorHandler {

    protected suspend fun <Out> getResult(
        call: suspend () -> Out
    ): Result<Out> = try {
        Result.Success(call())
    } catch (e: Exception) {
        Result.Error(error = getError(e).toDomain())
    }

    override suspend fun getError(throwable: Throwable): ErrorSource = when (throwable) {
        is HttpException -> {
            val errorBodyResponse = throwable.response()?.errorBody()?.string() ?: emptyString()

            if (isValidJSON(errorBodyResponse)) {
                val errorBody = Gson().fromJson(errorBodyResponse, ErrorNetwork::class.java)
                ErrorSource.ServiceError(
                    errorCode = errorBody.msg
                )

            } else {
                ErrorSource.Generic
            }
        }

        is IOException -> {
            when (throwable) {
                is SocketTimeoutException -> ErrorSource.TimeOut
                else -> ErrorSource.Generic
            }
        }

        else -> ErrorSource.Generic
    }

    private fun isValidJSON(json: String?): Boolean {
        try {
            JSONObject(json!!)
        } catch (ex: JSONException) {
            try {
                JSONArray(json)
            } catch (ex1: JSONException) {
                return false
            }
        } catch (ex2: JsonParseException) {
            return false
        }
        return true
    }
}
