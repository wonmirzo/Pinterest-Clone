package com.wonmirzo.fragment

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.widget.NestedScrollView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SimpleItemAnimator
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.wonmirzo.R
import com.wonmirzo.adapter.HomeFilterAdapter
import com.wonmirzo.adapter.HomePostAdapter
import com.wonmirzo.helper.SpacesItemDecoration
import com.wonmirzo.listener.OnBottomReachedListener
import com.wonmirzo.model.HomeFilter
import com.wonmirzo.network.RetrofitHttp
import com.wonmirzo.network.model.HomePost
import com.wonmirzo.utils.Logger
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment(R.layout.fragment_home) {
    private lateinit var rvFilterHome: RecyclerView
    private lateinit var rvPostHome: RecyclerView

    private lateinit var posts: ArrayList<HomePost>
    private val result = HashMap<String, String>()
    var page: Int = 1
    private val per_page = 20

    private lateinit var postAdapter: HomePostAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initViews(view)
    }

    private fun initViews(view: View) {
        result["page"] = page.toString()
        result["per_page"] = per_page.toString()
        result["order_by"] = "latest"

        posts = ArrayList()

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
        refreshPostAdapter(posts)
    }

    private fun refreshFilterAdapter(filters: List<HomeFilter>) {
        val adapter = HomeFilterAdapter(requireContext(), filters)
        rvFilterHome.adapter = adapter
    }

    private fun refreshPostAdapter(posts: ArrayList<HomePost>) {
        postAdapter = HomePostAdapter(posts, object : OnBottomReachedListener {
            override fun onBottomReached(position: Int) {
                Logger.d("@@@", "onBottomReached $position")
                if (page < 4) {
                    page++
                    result["page"] = page.toString()
                    apiPhotoList()
                } else {
                    Toast.makeText(
                        requireContext(),
                        "You have reached all photos",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        })
        rvPostHome.adapter = postAdapter
    }

    private fun getAllFilters(): List<HomeFilter> {
        val filters = ArrayList<HomeFilter>()
        filters.add(HomeFilter("For You", true))
        filters.add(HomeFilter("Today", false))
        filters.add(HomeFilter("Following", false))
        filters.add(HomeFilter("Health", false))
        filters.add(HomeFilter("Recipes", false))
        return filters
    }

    private fun apiPhotoList() {
        RetrofitHttp.posterService.listPost(result).enqueue(object : Callback<List<HomePost>> {
            @SuppressLint("NotifyDataSetChanged")
            override fun onResponse(
                call: Call<List<HomePost>>,
                response: Response<List<HomePost>>
            ) {
                if (!response.isSuccessful) {
                    Logger.e("@@@", "Code: ${response.code()}")
                    return
                }
                Logger.d("@@@", "page : $page")
                Logger.d("@@@", "result.page : ${result["page"]}")
                posts.addAll(response.body()!!)
                postAdapter.notifyDataSetChanged()
                Logger.d("@@@", "photos size: " + response.body()!!.size.toString())
            }

            override fun onFailure(call: Call<List<HomePost>>, t: Throwable) {
                Logger.e("@@@", "error ${t.message}")
            }
        })
    }
}