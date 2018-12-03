package com.eakurnikov.followinc.data.network.api

import com.eakurnikov.followinc.data.network.models.PostDto
import io.reactivex.Single
import retrofit2.http.GET

/**
 * Created by eakurnikov on 04.12.2018.
 */

interface PostApi {

    @GET("/posts")
    fun getPosts(): Single<List<PostDto>>
}