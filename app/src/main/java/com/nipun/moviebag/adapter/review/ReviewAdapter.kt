package com.nipun.moviebag.adapter.review

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nipun.moviebag.R
import com.nipun.moviebag.model.reviews.Results

class ReviewAdapter(private val moviesList: List<Results>) :
    RecyclerView.Adapter<ReviewViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_review, parent, false)
        return ReviewViewHolder(view)
    }

    override fun onBindViewHolder(holder: ReviewViewHolder, position: Int) {
        val moviesItem = moviesList[position]
        holder.setData(moviesItem)
    }

    override fun getItemCount(): Int {
        return moviesList.size
    }


}