package com.wonmirzo.network.services

import com.wonmirzo.R
import com.wonmirzo.network.model.HomePost
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface PhotoService {
    @Headers("Authorization:Client-ID uvJnbUX7b8Kupk47NngMXOMoChv_3t5C7W3xbqALKEs")

    @GET("photos")
    fun listPost(): Call<List<HomePost>>

}