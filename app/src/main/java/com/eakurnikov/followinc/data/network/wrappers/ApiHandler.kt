package com.eakurnikov.followinc.data.network.wrappers

import com.eakurnikov.followinc.di.annotations.ApplicationScope
import io.reactivex.SingleTransformer
import javax.inject.Inject

/**
 * Created by eakurnikov on 04.12.2018.
 */

@ApplicationScope
class ApiHandler @Inject constructor(private val authorizationController: AuthorizationController) {

    fun <T> get(): SingleTransformer<T, T> = SingleTransformer { it.compose(authorizationController.get<T>()) }
}