package com.example.saveo_assignment.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.saveo_assignment.R
import com.example.saveo_assignment.clickListeners.ImageClickListener
import com.example.saveo_assignment.databinding.ActivityMainBinding
import com.example.saveo_assignment.model.ShowsModel
import com.example.saveo_assignment.network.Status
import com.example.saveo_assignment.repositories.MoviesRepository
import com.example.saveo_assignment.ui.adapter.MoviesAdapter
import com.example.saveo_assignment.ui.adapter.TrendingMoviesAdapter
import com.example.saveo_assignment.viewmodel.MoviesViewModel
import com.example.saveo_assignment.viewmodel.MoviesViewModelFactory

class MainActivity : AppCompatActivity() , ImageClickListener{

    private lateinit var binding: ActivityMainBinding
    private var moviesList = mutableListOf<ShowsModel>()
    private lateinit var moviesAdapter: MoviesAdapter
    private lateinit var trendingMoviesAdapter: TrendingMoviesAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val repository = MoviesRepository()
        val viewModelFactory = MoviesViewModelFactory(repository)
        val viewModel =
            ViewModelProviders.of(this, viewModelFactory).get(MoviesViewModel::class.java)

        binding.rvMoviesList.layoutManager =
            GridLayoutManager(this, 3)
        moviesAdapter = MoviesAdapter(moviesList)
        binding.rvMoviesList.adapter = moviesAdapter

        binding.rvTrendingList.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        trendingMoviesAdapter = TrendingMoviesAdapter(moviesList)
        binding.rvTrendingList.adapter = trendingMoviesAdapter

        viewModel.getMoviesViewModel(1).observe(this, Observer {
            moviesList.clear()
            val res = it.data!!
            moviesList.addAll(res)
            Log.d("lol", moviesList.size.toString())
            moviesAdapter.notifyDataSetChanged()
            trendingMoviesAdapter.notifyDataSetChanged()
        })
    }

    override fun onImageClicked(showsModel: ShowsModel) {

    }
}