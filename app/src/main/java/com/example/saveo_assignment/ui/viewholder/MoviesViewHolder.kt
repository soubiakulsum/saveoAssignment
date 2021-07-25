package com.example.saveo_assignment.ui.viewholder

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.saveo_assignment.R
import com.example.saveo_assignment.model.MoviesResponseModelItem
import com.example.saveo_assignment.model.ShowsModel

class MoviesViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
    fun setData(moviesItem: ShowsModel) {
        view.apply {
            val mIvImage = findViewById<ImageView>(R.id.ivImgShow)

            Glide.with(context).load(moviesItem.image?.original).into(mIvImage)
        }
    }

}