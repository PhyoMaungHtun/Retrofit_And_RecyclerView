package com.retrofit_and_recyclerview.pmt.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.retrofit_and_recyclerview.pmt.R
import com.retrofit_and_recyclerview.pmt.model.Post

class PostAdapter(val context: Context,val post: List<Post>) :RecyclerView.Adapter<PostAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.post_item,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val cast = post[position]
        holder.tv_id.text = cast.id
        holder.tv_title.text = cast.title
    }

    override fun getItemCount(): Int {
      return post.size
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var tv_id: TextView = itemView.findViewById(R.id.tv_id)
        var tv_title: TextView = itemView.findViewById(R.id.tv_title)
    }
}