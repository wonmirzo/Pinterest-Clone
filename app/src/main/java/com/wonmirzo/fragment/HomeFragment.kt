package com.wonmirzo.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SimpleItemAnimator
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.wonmirzo.R
import com.wonmirzo.adapter.HomeFilterAdapter
import com.wonmirzo.adapter.HomePostAdapter
import com.wonmirzo.helper.SpacesItemDecoration
import com.wonmirzo.model.HomeFilter
import com.wonmirzo.model.HomePost

class HomeFragment : Fragment() {
    private lateinit var rvFilterHome: RecyclerView
    private lateinit var rvPostHome: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        rvFilterHome = view.findViewById(R.id.rvFilterHome)
        rvFilterHome.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        (rvFilterHome.itemAnimator as SimpleItemAnimator).supportsChangeAnimations = false

        rvPostHome = view.findViewById(R.id.rvPostHome)
        rvPostHome.layoutManager =
            StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)
        val decoration = SpacesItemDecoration(10)
        rvPostHome.addItemDecoration(decoration)

        refreshFilterAdapter(getAllFilters())
        refreshPostAdapter(getAllPosts())

        return view
    }

    private fun refreshFilterAdapter(filters: List<HomeFilter>) {
        val adapter = HomeFilterAdapter(requireContext(), filters)
        rvFilterHome.adapter = adapter
    }

    private fun refreshPostAdapter(posts: List<HomePost>) {
        val adapter = HomePostAdapter(requireContext(), posts)
        rvPostHome.adapter = adapter
    }

    private fun getAllFilters(): List<HomeFilter> {
        val filters = ArrayList<HomeFilter>()
        filters.add(HomeFilter("For You"))
        filters.add(HomeFilter("Today"))
        filters.add(HomeFilter("Following"))
        filters.add(HomeFilter("Health"))
        filters.add(HomeFilter("Recipes"))
        return filters
    }

    private fun getAllPosts(): List<HomePost> {
        val posts = ArrayList<HomePost>()
        posts.add(
            HomePost(
                "https://images.unsplash.com/photo-1640622299485-7fef00b3dc24?ixlib=rb-1.2.1&ixid=MnwxMjA3fDF8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=387&q=80",
                ""
            )
        )
        posts.add(
            HomePost(
                "https://images.unsplash.com/photo-1646518168341-d674899c5254?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxlZGl0b3JpYWwtZmVlZHw1fHx8ZW58MHx8fHw%3D&auto=format&fit=crop&w=500&q=60",
                ""
            )
        )
        posts.add(
            HomePost(
                "https://images.unsplash.com/photo-1646590637876-af1293d75122?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxlZGl0b3JpYWwtZmVlZHw3fHx8ZW58MHx8fHw%3D&auto=format&fit=crop&w=500&q=60",
                ""
            )
        )
        posts.add(
            HomePost(
                "https://images.unsplash.com/photo-1646639138820-54404ddb351b?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxlZGl0b3JpYWwtZmVlZHwxN3x8fGVufDB8fHx8&auto=format&fit=crop&w=500&q=60",
                ""
            )
        )
        return posts
    }

}