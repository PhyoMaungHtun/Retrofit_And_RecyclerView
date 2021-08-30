package com.retrofit_and_recyclerview.pmt.services

import com.retrofit_and_recyclerview.pmt.model.Post
import retrofit2.Call
import retrofit2.http.GET

interface Webservice {
    @GET("/Retrofit_And_RecyclerView/test_json.txt")
    fun getAllPost(): Call<List<Post>>
}