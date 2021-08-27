package com.nipun.moviebag.adapter.similarMovies

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nipun.moviebag.R
import com.nipun.moviebag.clickListener.ImageClickListener
import com.nipun.moviebag.model.topRated.Result

class SimilarMovieAdapter(private val trendingList: List<Result>, private val imageClickListener : ImageClickListener) :
    RecyclerView.Adapter<SimilarViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimilarViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_similar, parent, false)
        return SimilarViewHolder(view,imageClickListener)
    }

    override fun onBindViewHolder(holder: SimilarViewHolder, position: Int) {
        val trendingList = trendingList[position]
        holder.setData(trendingList)
    }

    override fun getItemCount(): Int {
        return trendingList.size
    }

}