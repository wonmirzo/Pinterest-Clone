package com.wonmirzo.fragment.message

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.wonmirzo.R
import com.wonmirzo.adapter.MessageUpdatesAdapter
import com.wonmirzo.model.MessageUpdates

class UpdatesFragment : Fragment(R.layout.fragment_updates) {
    private lateinit var recyclerView: RecyclerView
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 1)
        recyclerView.isNestedScrollingEnabled = false

        refreshAdapter(getAllUpdates())
    }

    private fun refreshAdapter(updates: List<MessageUpdates>) {
        val adapter = MessageUpdatesAdapter(requireContext(), updates)
        recyclerView.adapter = adapter
    }

    private fun getAllUpdates(): List<MessageUpdates> {
        val updates = ArrayList<MessageUpdates>()
        updates.add(
            MessageUpdates(
                "https://images.unsplash.com/photo-1543876140-dc6979975b25?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MXx8b3dsfGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=500&q=60",
                "More inspiration based on your interest in bird",
                "21h"
            )
        )
        updates.add(
            MessageUpdates(
                "https://images.unsplash.com/photo-1560869713-7d0a29430803?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Nnx8aGFpcnN0eWxlfGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=500&q=60",
                "Hairstyles, Hair, outfits and accessories and 10 other boards picked for you",
                "2d"
            )
        )
        return updates
    }
}