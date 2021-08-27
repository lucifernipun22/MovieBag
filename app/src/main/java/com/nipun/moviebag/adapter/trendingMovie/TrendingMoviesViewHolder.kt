package com.nipun.moviebag.adapter.trendingMovie

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nipun.moviebag.R
import com.nipun.moviebag.clickListener.ImageClickListener
import com.nipun.moviebag.model.topRated.Result

class TrendingMoviesViewHolder (private val view: View,private val imageClickListener : ImageClickListener) : RecyclerView.ViewHolder(view) {
    fun setData(moviesItem: Result) {
        view.apply {
            val mIvImage = findViewById<ImageView>(R.id.ivImgShow)


            Glide.with(context).load(BASE_IMAGE_URL +moviesItem.poster_path).into(mIvImage)

            mIvImage.setOnClickListener {
                imageClickListener.onImageClickedToRated(moviesItem,mIvImage)
            }
        }
    }
    companion object {
        const val BASE_IMAGE_URL = "https://image.tmdb.org/t/p/w300"
    }
}