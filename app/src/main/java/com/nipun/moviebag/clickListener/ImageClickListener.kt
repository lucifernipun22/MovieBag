package com.nipun.moviebag.clickListener

import android.widget.ImageView
import com.nipun.moviebag.model.movieList.Movie
import com.nipun.moviebag.model.topRated.Result

interface ImageClickListener {

    /**
     * function to implement in a activity when user want to click on particular item of recyclerview
     */
    fun onImageClicked(movieResponse: Movie, mIvImage: ImageView)
    /**
     * function to implement in a activity when user want to click on particular item of recyclerview
     */
    fun onImageClickedToRated(movieResponse: Result, mIvImage: ImageView)
}