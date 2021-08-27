package com.nipun.moviebag.adapter.cast

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nipun.moviebag.R
import com.nipun.moviebag.model.casts.CastX

/**
 * view holder of cast activity update the data
 */
class CastViewHolder (private val view: View) :
    RecyclerView.ViewHolder(view) {
    fun setData(moviesItem: CastX) {
        view.apply {
            val mIvImage = findViewById<ImageView>(R.id.ivAvatar1)


            Glide.with(context).load(BASE_IMAGE_URL + moviesItem.profile_path).into(mIvImage)
            val Name = findViewById<TextView>(R.id.Name)
            Name.text = moviesItem.name
            val position = findViewById<TextView>(R.id.position1)
            position.text = moviesItem.character


        }
    }

    companion object {
        const val BASE_IMAGE_URL = "https://image.tmdb.org/t/p/w300"
    }
}