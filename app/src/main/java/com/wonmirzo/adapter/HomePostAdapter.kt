package com.wonmirzo.adapter

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.imageview.ShapeableImageView
import com.wonmirzo.R
import com.wonmirzo.listener.OnBottomReachedListener
import com.wonmirzo.network.model.HomePost


class HomePostAdapter(
    private var posts: ArrayList<HomePost>,
    private var listener: OnBottomReachedListener
) :
    RecyclerView.Adapter<HomePostAdapter.VH>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomePostAdapter.VH {
        return VH(
            LayoutInflater.from(parent.context).inflate(R.layout.item_post_home_view, parent, false)
        )
    }

    override fun onBindViewHolder(holder: HomePostAdapter.VH, position: Int) {
        val post = posts[position]

        val ivPhoto = holder.ivPhoto

        Glide.with(ivPhoto.context)
            .load(post.urls.small)
            .placeholder(ColorDrawable(Color.parseColor(post.color)))
            .fitCenter()
            .into(ivPhoto)


        if (position == posts.size - 1) {
            listener.onBottomReached(position)
        }
    }

    override fun getItemCount(): Int = posts.size

    class VH(view: View) : RecyclerView.ViewHolder(view) {
        val ivPhoto: ShapeableImageView = view.findViewById(R.id.ivPhoto)
    }
}