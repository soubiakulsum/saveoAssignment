package com.example.saveo_assignment.ui.viewholder

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.saveo_assignment.R
import com.example.saveo_assignment.clickListeners.ImageClickListener
import com.example.saveo_assignment.model.ShowsModel
import java.util.*

class MoviesViewHolder(private val view: View,private val imageClickListener : ImageClickListener) : RecyclerView.ViewHolder(view) {
    fun setData(moviesItem: ShowsModel) {
        view.apply {
            val mIvImage = findViewById<ImageView>(R.id.ivImgShow)


            Glide.with(context).load(moviesItem.image?.original).placeholder(ColorDrawable(getRandomColor())).into(mIvImage)

            mIvImage.setOnClickListener {
                imageClickListener.onImageClicked(moviesItem,mIvImage)
            }
        }
    }
    fun getRandomColor(): Int {
        val colours: MutableList<Int> = ArrayList()
        colours.add(Color.parseColor("#FED8A9"))
        colours.add(Color.parseColor("#C599D6"))
        colours.add(Color.parseColor("#78D6C6"))
        colours.add(Color.parseColor("#A6B8FF"))
        colours.add(Color.parseColor("#E5B9D2"))
        colours.add(Color.parseColor("#FFEABF"))
        colours.add(Color.parseColor("#CCBBE5"))
        colours.add(Color.parseColor("#BCE4FE"))
        colours.add(Color.parseColor("#DAF5A8"))
        colours.add(Color.parseColor("#FFA4B5"))
        colours.add(Color.parseColor("#92CED8"))
        colours.add(Color.parseColor("#DBCBA7"))
        val rand = Random()
        return colours[rand.nextInt(colours.size)]
    }
}