package com.wonmirzo.network.model

import com.google.gson.annotations.SerializedName

data class Urls(
    @SerializedName("small")
    val small: String? = null,

    @SerializedName("small_s3")
    val smallS3: String? = null,

    @SerializedName("thumb")
    val thumb: String? = null,

    @SerializedName("raw")
    val raw: String? = null,

    @SerializedName("regular")
    val regular: String? = null,

    @SerializedName("full")
    val full: String? = null
)
