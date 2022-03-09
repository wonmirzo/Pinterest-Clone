package com.wonmirzo.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.wonmirzo.R
import com.wonmirzo.adapter.SearchIdeaAdapter
import com.wonmirzo.adapter.SearchPopularAdapter
import com.wonmirzo.model.SearchIdeas
import com.wonmirzo.model.SearchPopular

class SearchFragment : Fragment() {
    private lateinit var rvSearchIdeas: RecyclerView
    private lateinit var rvSearchPopular: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_search, container, false)

        rvSearchIdeas = view.findViewById(R.id.rvSearchIdeas)
        rvSearchIdeas.layoutManager = GridLayoutManager(requireContext(), 2)
        rvSearchIdeas.isNestedScrollingEnabled = false

        rvSearchPopular = view.findViewById(R.id.rvSearchPopular)
        rvSearchPopular.layoutManager = GridLayoutManager(requireContext(), 2)
        rvSearchPopular.isNestedScrollingEnabled = false

        refreshIdeasAdapter(getAllIdeas())
        refreshPopularAdapter(getAllPopular())

        return view
    }

    private fun refreshIdeasAdapter(ideas: List<SearchIdeas>) {
        val adapter = SearchIdeaAdapter(requireContext(), ideas)
        rvSearchIdeas.adapter = adapter
    }

    private fun refreshPopularAdapter(populars: List<SearchPopular>) {
        val adapter = SearchPopularAdapter(requireContext(), populars)
        rvSearchPopular.adapter = adapter
    }

    private fun getAllIdeas(): List<SearchIdeas> {
        val ideas = ArrayList<SearchIdeas>()
        ideas.add(
            SearchIdeas(
                "https://images.unsplash.com/photo-1562512231-d8f6b2b7cecd?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTd8fGFuaW1hbCUyMGRyYXdpbmdzfGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=500&q=60",
                "Animal drawings"
            )
        )
        ideas.add(
            SearchIdeas(
                "https://images.unsplash.com/photo-1522687533888-1078974f88ec?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MXx8bGlvbiUyMHRhdHRvb3xlbnwwfHwwfHw%3D&auto=format&fit=crop&w=500&q=60",
                "Lion tattoo"
            )
        )
        ideas.add(
            SearchIdeas(
                "https://images.unsplash.com/photo-1638171716796-275ff9827dc8?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8M3x8cGV0JTIwYmlyZHN8ZW58MHx8MHx8&auto=format&fit=crop&w=500&q=60",
                "Pet birds"
            )
        )
        ideas.add(
            SearchIdeas(
                "https://images.unsplash.com/photo-1522120657009-060ca01afcd6?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8OHx8b3dsJTIwcGljdHVyZXN8ZW58MHx8MHx8&auto=format&fit=crop&w=500&q=60",
                "Owl pictures"
            )
        )

        return ideas
    }

    private fun getAllPopular(): List<SearchPopular> {
        val populars = ArrayList<SearchPopular>()
        populars.add(
            SearchPopular(
                "https://images.unsplash.com/photo-1556911220-bff31c812dba?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MXx8a2l0Y2hlbnxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=500&q=60",
                "Kitchen ideas"
            )
        )
        populars.add(
            SearchPopular(
                "https://images.unsplash.com/photo-1535473895227-bdecb20fb157?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8NHx8ZGlubmVyfGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=500&q=60",
                "Easy dinner recipes"
            )
        )
        populars.add(
            SearchPopular(
                "https://images.unsplash.com/photo-1557682250-33bd709cbe85?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8M3x8cHVycGxlJTIwYmFja2dyb3VuZHxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=500&q=60",
                "Purple wallpaper iphone"
            )
        )
        populars.add(
            SearchPopular(
                "https://images.unsplash.com/photo-1554995207-c18c203602cb?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8NHx8cm9vbXxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=500&q=60",
                "Dream rooms"
            )
        )
        populars.add(
            SearchPopular(
                "https://images.unsplash.com/photo-1608562719218-920013a7a249?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8YXVyYXxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=500&q=60",
                "Aura colors"
            )
        )

        populars.add(
            SearchPopular(
                "https://images.unsplash.com/photo-1525310072745-f49212b5ac6d?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MXx8Zmxvd2VyfGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=500&q=60",
                "8 марта"
            )
        )

        populars.add(
            SearchPopular(
                "https://images.unsplash.com/photo-1571051549906-a659836d71f9?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8NHx8aGVhbHRoeWVhdGluZ3xlbnwwfHwwfHw%3D&auto=format&fit=crop&w=500&q=60",
                "Healthy eating"
            )
        )

        populars.add(
            SearchPopular(
                "https://images.unsplash.com/photo-1604709177225-055f99402ea3?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8NHx8YmF0aHJvb218ZW58MHx8MHx8&auto=format&fit=crop&w=500&q=60",
                "Bathroom interior design"
            )
        )

        return populars
    }

}