package com.nipun.moviebag.clickListener

import android.widget.ImageView
import com.nipun.moviebag.model.movieList.Movie
import com.nipun.moviebag.model.topRated.Result

interface ImageClickListener {
    fun onImageClicked(movieResponse: Movie, mIvImage: ImageView)

    fun onImageClickedToRated(movieResponse: Result, mIvImage: ImageView)
}