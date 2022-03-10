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
import com.wonmirzo.network.RetrofitHttp
import com.wonmirzo.network.model.HomePost
import com.wonmirzo.utils.Logger
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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
        rvPostHome.setHasFixedSize(true)
        rvPostHome.layoutManager =
            StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        val decoration = SpacesItemDecoration(10)
        rvPostHome.addItemDecoration(decoration)

        refreshFilterAdapter(getAllFilters())
        apiPhotoList()

        return view
    }

    private fun refreshFilterAdapter(filters: List<HomeFilter>) {
        val adapter = HomeFilterAdapter(requireContext(), filters)
        rvFilterHome.adapter = adapter
    }

    private fun refreshPostAdapter(posts: ArrayList<HomePost>) {
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

    private fun apiPhotoList() {
        RetrofitHttp.posterService.listPost().enqueue(object : Callback<List<HomePost>> {
            override fun onResponse(
                call: Call<List<HomePost>>,
                response: Response<List<HomePost>>
            ) {
                if (!response.isSuccessful) {
                    Logger.e("@@@", "Code: ${response.code()}")
                    return
                }
                posts.clear()
                posts.addAll(response.body()!!)
                refreshPostAdapter(posts)

                Logger.d("@@@", "r: " + response.body()!!.size.toString())
            }

            override fun onFailure(call: Call<List<HomePost>>, t: Throwable) {
                Logger.e("@@@", "error ${t.message}")
            }
        })
    }

    companion object {
        val posts = ArrayList<HomePost>()

    }
}