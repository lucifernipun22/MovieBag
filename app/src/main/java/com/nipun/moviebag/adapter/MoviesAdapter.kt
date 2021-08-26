package com.nipun.moviebag.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nipun.moviebag.R
import com.nipun.moviebag.clickListener.ImageClickListener
import com.nipun.moviebag.model.movieList.Movie

class MoviesAdapter(private val moviesList: List<Movie>, private val imageClickListener : ImageClickListener) :
    RecyclerView.Adapter<MoviesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return MoviesViewHolder(view,imageClickListener)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        val moviesItem = moviesList[position]
        holder.setData(moviesItem)
    }

    override fun getItemCount(): Int {
        return moviesList.size
    }


}