package com.nipun.moviebag.adapter.production

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nipun.moviebag.R

import com.nipun.moviebag.model.movieDetails.ProductionCompany
import de.hdodenhof.circleimageview.CircleImageView

class ProductionViewHolder(private val view: View) :
    RecyclerView.ViewHolder(view) {
    fun setData(moviesItem: ProductionCompany) {
        view.apply {
            val mIvImage = findViewById<CircleImageView>(R.id.iv_avatar2)


            Glide.with(context).load(BASE_IMAGE_URL + moviesItem.logo_path).into(mIvImage)
        }
    }

    companion object {
        const val BASE_IMAGE_URL = "https://image.tmdb.org/t/p/w300"
    }
}