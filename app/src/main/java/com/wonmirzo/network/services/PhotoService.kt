package com.wonmirzo.network.services

import com.wonmirzo.helper.MyStrings
import com.wonmirzo.network.model.HomePost
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.QueryMap

interface PhotoService {
    @Headers("Authorization:Client-ID ${MyStrings.accessKey}")

    @GET("photos")
    fun listPost(@QueryMap result: MutableMap<String, String>): Call<List<HomePost>>

}