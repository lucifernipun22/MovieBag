package com.nipun.moviebag.adapter.cast

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nipun.moviebag.R
import com.nipun.moviebag.model.casts.CastX

/**
 * adapter for cast activity recycler view
 */
class CastAdapter(private val moviesList: List<CastX>) :
    RecyclerView.Adapter<CastViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CastViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_layout_cast, parent, false)
        return CastViewHolder(view)
    }

    override fun onBindViewHolder(holder: CastViewHolder, position: Int) {
        val moviesItem = moviesList[position]
        holder.setData(moviesItem)
    }

    override fun getItemCount(): Int {
        return moviesList.size
    }


}