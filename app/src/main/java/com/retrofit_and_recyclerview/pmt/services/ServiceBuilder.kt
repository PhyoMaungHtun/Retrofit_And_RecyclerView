package com.retrofit_and_recyclerview.pmt.services

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceBuilder {
    private const val BASE_URL = "https://phyomaunghtun.github.io/"

    private val OkHttp: OkHttpClient.Builder = OkHttpClient.Builder()

    private val builder: Retrofit.Builder = Retrofit.Builder()
        .baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
        .client(OkHttp.build())

    private val retrofit: Retrofit = builder.build()

   fun<T> buildService(serviceType: Class<T>): T{
       return retrofit.create(serviceType)
   }

}