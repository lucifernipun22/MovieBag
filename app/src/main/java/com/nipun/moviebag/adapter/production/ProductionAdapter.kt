package com.nipun.moviebag.adapter.production

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nipun.moviebag.R

import com.nipun.moviebag.model.movieDetails.ProductionCompany
/**
 * adapter for Production recycler view
 */
class ProductionAdapter (private var moviesList: List<ProductionCompany>) :
    RecyclerView.Adapter<ProductionViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductionViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_production, parent, false)
        return ProductionViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductionViewHolder, position: Int) {
        val moviesItem = moviesList[position]
        holder.setData(moviesItem)
    }

    override fun getItemCount(): Int {
        return moviesList.size
    }

    fun updateData(responseModelList: List<ProductionCompany>) {
        this.moviesList = responseModelList
        notifyDataSetChanged()
    }
}