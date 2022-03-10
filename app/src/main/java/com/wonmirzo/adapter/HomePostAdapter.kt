package com.wonmirzo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.imageview.ShapeableImageView
import com.wonmirzo.R
import com.wonmirzo.network.model.HomePost

class HomePostAdapter(private var context: Context, private var posts: ArrayList<HomePost>) :
    RecyclerView.Adapter<HomePostAdapter.VH>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomePostAdapter.VH {
        return VH(
            LayoutInflater.from(parent.context).inflate(R.layout.item_post_home_view, parent, false)
        )
    }

    override fun onBindViewHolder(holder: HomePostAdapter.VH, position: Int) {
        val post = posts[position]

        val ivPhoto = holder.ivPhoto

        Glide.with(ivPhoto.context).load(post.urls!!.small).into(ivPhoto)
    }

    override fun getItemCount(): Int = posts.size

    class VH(view: View) : RecyclerView.ViewHolder(view) {
        val ivPhoto: ShapeableImageView = view.findViewById(R.id.ivPhoto)
    }
}