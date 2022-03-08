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
import com.wonmirzo.model.MessageChats
import com.wonmirzo.model.MessageUpdates
import com.wonmirzo.model.SearchIdeas
import com.wonmirzo.model.SearchPopular

class MessageChatAdapter(
    private var context: Context,
    private var chats: List<MessageChats>
) :
    RecyclerView.Adapter<MessageChatAdapter.VH>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageChatAdapter.VH {
        return VH(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_message_chat_view, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MessageChatAdapter.VH, position: Int) {
        val chat = chats[position]

        val ivPhoto = holder.ivPhoto
        val tvTitle = holder.tvTitle
        val tvTime = holder.tvTime
        val tvMessage = holder.tvMessage

        Glide.with(ivPhoto.context).load(chat.photo).into(ivPhoto)
        tvTitle.text = chat.title
        tvTime.text = chat.time
        tvMessage.text = chat.message
    }

    override fun getItemCount(): Int = chats.size

    class VH(view: View) : RecyclerView.ViewHolder(view) {
        val ivPhoto: ShapeableImageView = view.findViewById(R.id.ivPhoto)
        val tvTitle: TextView = view.findViewById(R.id.tvTitle)
        val tvTime: TextView = view.findViewById(R.id.tvTime)
        val tvMessage: TextView = view.findViewById(R.id.tvMessage)
    }
}