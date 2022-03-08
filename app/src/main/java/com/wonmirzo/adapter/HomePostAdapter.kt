package com.wonmirzo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.imageview.ShapeableImageView
import com.wonmirzo.R
import com.wonmirzo.model.HomePost

class HomePostAdapter(private var context: Context, private var posts: List<HomePost>) :
    RecyclerView.Adapter<HomePostAdapter.VH>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomePostAdapter.VH {
        return VH(
            LayoutInflater.from(parent.context).inflate(R.layout.item_post_home_view, parent, false)
        )
    }

    override fun onBindViewHolder(holder: HomePostAdapter.VH, position: Int) {
        val post = posts[position]

        val ivPhoto = holder.ivPhoto
        val tvTitle = holder.tvTitle

        Glide.with(ivPhoto.context).load(post.photo).into(ivPhoto)
        tvTitle.text = post.title
    }

    override fun getItemCount(): Int = posts.size

    class VH(view: View) : RecyclerView.ViewHolder(view) {
        val ivPhoto: ShapeableImageView = view.findViewById(R.id.ivPhoto)
        val tvTitle: TextView = view.findViewById(R.id.tvTitle)
    }
}