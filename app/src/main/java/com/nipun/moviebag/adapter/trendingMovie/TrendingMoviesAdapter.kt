package com.nipun.moviebag.adapter.trendingMovie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nipun.moviebag.R
import com.nipun.moviebag.clickListener.ImageClickListener
import com.nipun.moviebag.model.topRated.Result

class TrendingMoviesAdapter(private val trendingList: List<Result>, private val imageClickListener : ImageClickListener) :
    RecyclerView.Adapter<TrendingMoviesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrendingMoviesViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.horizontal_item_layout, parent, false)
        return TrendingMoviesViewHolder(view,imageClickListener)
    }

    override fun onBindViewHolder(holder: TrendingMoviesViewHolder, position: Int) {
        val trendingList = trendingList[position]
        holder.setData(trendingList)
    }

    override fun getItemCount(): Int {
        return trendingList.size
    }

}