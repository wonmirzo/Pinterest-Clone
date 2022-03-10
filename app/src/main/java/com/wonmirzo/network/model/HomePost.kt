package com.wonmirzo.network.model

import com.google.gson.annotations.SerializedName

data class HomePost(
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("urls")
    val urls: Urls? = null
)
