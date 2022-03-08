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

class SearchIdeasAdapter(private var context: Context, private var ideas: List<SearchIdeas>) :
    RecyclerView.Adapter<SearchIdeasAdapter.VH>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchIdeasAdapter.VH {
        return VH(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_search_ideas_view, parent, false)
        )
    }

    override fun onBindViewHolder(holder: SearchIdeasAdapter.VH, position: Int) {
        val idea = ideas[position]

        val ivPhoto = holder.ivPhoto
        val tvTitle = holder.tvTitle

        Glide.with(ivPhoto.context).load(idea.photo).into(ivPhoto)
        tvTitle.text = idea.title
    }

    override fun getItemCount(): Int = ideas.size

    class VH(view: View) : RecyclerView.ViewHolder(view) {
        val ivPhoto: ShapeableImageView = view.findViewById(R.id.ivPhoto)
        val tvTitle: TextView = view.findViewById(R.id.tvTitle)
    }
}