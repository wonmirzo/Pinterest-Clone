package com.wonmirzo.fragment.message

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.wonmirzo.R
import com.wonmirzo.adapter.MessageChatAdapter
import com.wonmirzo.model.MessageChats

class ChatFragment : Fragment(R.layout.fragment_chat) {
    private lateinit var recyclerView: RecyclerView
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 1)
        recyclerView.isNestedScrollingEnabled = false

        refreshAdapter(getAllChats())
    }

    private fun refreshAdapter(chats: List<MessageChats>) {
        val adapter = MessageChatAdapter(requireContext(), chats)
        recyclerView.adapter = adapter
    }

    private fun getAllChats(): List<MessageChats> {
        val chats = ArrayList<MessageChats>()
        chats.add(
            MessageChats(
                "https://images.unsplash.com/photo-1543876140-dc6979975b25?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MXx8b3dsfGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=500&q=60",
                "Mutofa Mahmudiy",
                "1d",
                "follow me bro"
            )
        )

        return chats
    }
}