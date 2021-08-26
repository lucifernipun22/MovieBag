package com.nipun.moviebag.adapter


import android.view.View
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nipun.moviebag.R
import com.nipun.moviebag.clickListener.ImageClickListener
import com.nipun.moviebag.model.movieList.Movie


class MoviesViewHolder(private val view: View, private val imageClickListener: ImageClickListener) :
    RecyclerView.ViewHolder(view) {
    fun setData(moviesItem: Movie) {
        view.apply {
            val mIvImage = findViewById<ImageView>(R.id.ivAvatar)


            Glide.with(context).load(BASE_IMAGE_URL + moviesItem.poster_path).into(mIvImage)
            val movieName = findViewById<TextView>(R.id.MovieName)
            movieName.text = moviesItem.original_title
            val language = findViewById<TextView>(R.id.LanguageValue)
            language.text = moviesItem.original_language
            val releaseDate = findViewById<TextView>(R.id.ReleaseDateValue)
            releaseDate.text = moviesItem.release_date
            mIvImage.setOnClickListener {
                imageClickListener.onImageClicked(moviesItem, mIvImage)
                val ratingBar = findViewById<RatingBar>(R.id.starRatingBar)
                ratingBar.rating = moviesItem.vote_average.toString().toFloat() / 2
                val ratingText = findViewById<TextView>(R.id.tvStarRating)
                ratingText.text = moviesItem.vote_average.toString()
            }
        }
    }

    companion object {
        const val BASE_IMAGE_URL = "https://image.tmdb.org/t/p/w300"
    }
}