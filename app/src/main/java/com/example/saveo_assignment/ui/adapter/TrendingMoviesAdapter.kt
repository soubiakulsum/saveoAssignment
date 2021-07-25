package com.example.saveo_assignment.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.saveo_assignment.R
import com.example.saveo_assignment.model.ShowsModel
import com.example.saveo_assignment.ui.viewholder.MoviesViewHolder

class TrendingMoviesAdapter(private val trendingList: List<ShowsModel>) :
    RecyclerView.Adapter<MoviesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.movies_item_layout, parent, false)
        return MoviesViewHolder(view)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        val trendingList = trendingList[position]
        holder.setData(trendingList)
    }

    override fun getItemCount(): Int {
        return trendingList.size
    }

}