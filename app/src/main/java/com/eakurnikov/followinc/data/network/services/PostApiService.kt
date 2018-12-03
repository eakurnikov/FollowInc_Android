package com.eakurnikov.followinc.data.network.services

import com.eakurnikov.followinc.di.annotations.ApplicationScope
import com.eakurnikov.followinc.data.network.models.PostDto
import com.eakurnikov.followinc.data.network.wrappers.ApiHandler
import com.eakurnikov.followinc.data.network.api.PostApi
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by eakurnikov on 04.12.2018.
 */

@ApplicationScope
class PostApiService @Inject constructor(
    private val postApi: PostApi,
    private val apiHandler: ApiHandler
) {
    fun getPosts(): Single<List<PostDto>> = postApi.getPosts().compose(apiHandler.get())
}