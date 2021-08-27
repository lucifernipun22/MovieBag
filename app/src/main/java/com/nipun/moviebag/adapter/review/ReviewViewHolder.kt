package com.nipun.moviebag.adapter.review

import android.view.View
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nipun.moviebag.R
import com.nipun.moviebag.model.reviews.Results
import de.hdodenhof.circleimageview.CircleImageView
/**
 * view holder of Review activity update the data
 */
class ReviewViewHolder (private val view: View) :
    RecyclerView.ViewHolder(view) {
    fun setData(moviesItem: Results) {
        view.apply {
            val mIvImage = findViewById<CircleImageView>(R.id.profile_image)

            Glide.with(context).load(BASE_IMAGE_URL + moviesItem.author_details.avatar_path).into(mIvImage)
            val Name = findViewById<TextView>(R.id.tvTitle1)
            Name.text = moviesItem.author_details.username
            val date = findViewById<TextView>(R.id.ReleaseDateValue1)
            date.text = moviesItem.updated_at
            val content = findViewById<TextView>(R.id.Rating)
            content.text = moviesItem.content
            val ratingBar = findViewById<RatingBar>(R.id.starRatingBar1)
            ratingBar.rating = moviesItem.author_details.rating.toString().toFloat() / 2
        }
    }

    companion object {
        const val BASE_IMAGE_URL = "https://image.tmdb.org/t/p/w300"
    }
}