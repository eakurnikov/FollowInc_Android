package com.eakurnikov.followinc.data.network.wrappers

import com.eakurnikov.followinc.di.annotations.ApplicationScope
import io.reactivex.Single
import io.reactivex.SingleTransformer
import retrofit2.HttpException
import java.net.HttpURLConnection
import javax.inject.Inject

/**
 * Created by eakurnikov on 04.12.2018.
 */

// TODO implement

@ApplicationScope
class AuthorizationController @Inject constructor() {

    fun <T> get(): SingleTransformer<T, T> {
        return SingleTransformer { single ->
            single.onErrorResumeNext { e ->
                if (isUnauthorized(e)) {
                    // ...
                } else {
                    Single.error<T>(e)
                }

                Single.error<T>(e)
            }
        }
    }

    private fun isUnauthorized(e: Throwable) = e is HttpException && isUnauthorizedCode(e.code())

    private fun isUnauthorizedCode(code: Int) = code == HttpURLConnection.HTTP_UNAUTHORIZED
}