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
import com.wonmirzo.model.SearchIdeas
import com.wonmirzo.model.SearchPopular

class SearchPopularAdapter(
    private var context: Context,
    private var populars: List<SearchPopular>
) :
    RecyclerView.Adapter<SearchPopularAdapter.VH>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchPopularAdapter.VH {
        return VH(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_search_popular_view, parent, false)
        )
    }

    override fun onBindViewHolder(holder: SearchPopularAdapter.VH, position: Int) {
        val popular = populars[position]

        val ivPhoto = holder.ivPhoto
        val tvTitle = holder.tvTitle

        Glide.with(ivPhoto.context).load(popular.photo).into(ivPhoto)
        tvTitle.text = popular.title
    }

    override fun getItemCount(): Int = populars.size

    class VH(view: View) : RecyclerView.ViewHolder(view) {
        val ivPhoto: ShapeableImageView = view.findViewById(R.id.ivPhoto)
        val tvTitle: TextView = view.findViewById(R.id.tvTitle)
    }
}