package com.example.saveo_assignment.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.saveo_assignment.R
import com.example.saveo_assignment.model.MoviesResponseModelItem
import com.example.saveo_assignment.model.ShowsModel
import com.example.saveo_assignment.ui.viewholder.MoviesViewHolder

class MoviesAdapter(private val moviesList: List<ShowsModel>) :
    RecyclerView.Adapter<MoviesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.movies_item_layout, parent, false)
        return MoviesViewHolder(view)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        val moviesItem = moviesList[position]
        holder.setData(moviesItem)
    }

    override fun getItemCount(): Int {
        return moviesList.size
    }


}