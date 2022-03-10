package com.wonmirzo.network

import com.wonmirzo.network.services.PhotoService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHttp {
    const val IS_TESTER = true
    private const val SERVER_DEVELOPMENT = "https://api.unsplash.com/"
    private const val SERVER_PRODUCTION = "https://api.unsplash.com/"

    private val retrofit =
        Retrofit.Builder()
            .baseUrl(server())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    private fun server(): String {
        if (IS_TESTER) return SERVER_DEVELOPMENT
        return SERVER_PRODUCTION
    }

    val posterService: PhotoService = retrofit.create(PhotoService::class.java)
    //...
}