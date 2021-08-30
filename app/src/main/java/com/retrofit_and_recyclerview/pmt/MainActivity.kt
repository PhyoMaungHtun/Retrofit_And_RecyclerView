package com.retrofit_and_recyclerview.pmt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.retrofit_and_recyclerview.pmt.adapter.PostAdapter
import com.retrofit_and_recyclerview.pmt.libby.E.Companion.msg
import com.retrofit_and_recyclerview.pmt.model.Post
import com.retrofit_and_recyclerview.pmt.services.ServiceBuilder
import com.retrofit_and_recyclerview.pmt.services.Webservice
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recyclerView)

        recyclerView.layoutManager = LinearLayoutManager(this)

        getAllPost()
    }

    private fun getAllPost(){
       val service: Webservice = ServiceBuilder.buildService(Webservice::class.java)
        val response: Call<List<Post>> = service.getAllPost()

        response.enqueue(object: Callback<List<Post>>{
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                if (response.isSuccessful) {
                    val cast: List<Post> = response.body()!!
                    recyclerView.adapter = PostAdapter(this@MainActivity,cast)
                   // msg(cast.toString())
                }else{
                    msg(response.message())
                }
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                msg(t.message.toString())
            }

        })
    }
}