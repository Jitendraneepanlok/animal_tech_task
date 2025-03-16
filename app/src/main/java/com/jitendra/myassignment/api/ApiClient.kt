package com.jitendra.myassignment.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    private const val BASE_URL = "https://storage.googleapis.com/animall.appspot.com/"

    val api: EmployeeApi by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(EmployeeApi::class.java)
    }
}
