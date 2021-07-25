package com.example.saveo_assignment.clickListeners

import android.widget.ImageView
import com.example.saveo_assignment.model.ShowsModel

interface ImageClickListener {
    fun onImageClicked(showsModel: ShowsModel, mIvImage: ImageView)
}