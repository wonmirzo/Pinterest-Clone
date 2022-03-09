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
import com.wonmirzo.model.MessageUpdates

class MessageUpdateAdapter(
    private var context: Context,
    private var updates: List<MessageUpdates>
) :
    RecyclerView.Adapter<MessageUpdateAdapter.VH>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageUpdateAdapter.VH {
        return VH(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_message_updates_view, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MessageUpdateAdapter.VH, position: Int) {
        val update = updates[position]

        val ivPhoto = holder.ivPhoto
        val tvTitle = holder.tvTitle
        val tvTime = holder.tvTime

        Glide.with(ivPhoto.context).load(update.photo).into(ivPhoto)
        tvTitle.text = update.title
        tvTime.text = update.time
    }

    override fun getItemCount(): Int = updates.size

    class VH(view: View) : RecyclerView.ViewHolder(view) {
        val ivPhoto: ShapeableImageView = view.findViewById(R.id.ivPhoto)
        val tvTitle: TextView = view.findViewById(R.id.tvTitle)
        val tvTime: TextView = view.findViewById(R.id.tvTime)
    }
}