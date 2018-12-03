package com.eakurnikov.followinc.data.network.models

import com.google.gson.annotations.SerializedName

/**
 * Created by eakurnikov on 04.12.2018.
 */

data class PostDto(

    @SerializedName("userId")
    val userId: Int,

    @SerializedName("id")
    val id: Int,

    @SerializedName("title")
    val title: String,

    @SerializedName("body")
    val body: String
)