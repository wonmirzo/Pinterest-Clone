package com.wonmirzo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.RecyclerView
import com.wonmirzo.R
import com.wonmirzo.model.HomeFilter

class HomeFilterAdapter(private var context: Context, private var filters: List<HomeFilter>) :
    RecyclerView.Adapter<HomeFilterAdapter.VH>() {
    private var selectedItemPos = -1
    private var lastItemSelectedPos = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeFilterAdapter.VH =
        VH(LayoutInflater.from(parent.context).inflate(R.layout.item_filter_view, parent, false))

    override fun onBindViewHolder(holder: HomeFilterAdapter.VH, position: Int) {
        val filter = filters[position]
        val tvFilter = holder.tvFilter
        tvFilter.text = filter.text

        tvFilter.setOnClickListener {
            selectedItemPos = holder.adapterPosition
            lastItemSelectedPos = if (lastItemSelectedPos == -1)
                selectedItemPos
            else {
                notifyItemChanged(lastItemSelectedPos)
                selectedItemPos
            }
            notifyItemChanged(selectedItemPos)
        }

        if (position == selectedItemPos)
            holder.selectedBg()
        else
            holder.defaultBg()


    }

    override fun getItemCount(): Int = filters.size

    class VH(view: View) : RecyclerView.ViewHolder(view) {
        var tvFilter: TextView = view.findViewById(R.id.tvFilter)

        fun defaultBg() {
            tvFilter.background = AppCompatResources.getDrawable(
                itemView.context,
                R.drawable.bg_home_filter_unselected
            )
            tvFilter.setTextColor(itemView.resources.getColor(R.color.black))
        }

        fun selectedBg() {
            tvFilter.background = AppCompatResources.getDrawable(
                itemView.context,
                R.drawable.bg_home_filter_selected
            )
            tvFilter.setTextColor(itemView.resources.getColor(R.color.white))
        }
    }

}