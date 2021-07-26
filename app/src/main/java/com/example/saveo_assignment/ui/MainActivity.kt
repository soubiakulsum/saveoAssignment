package com.example.saveo_assignment.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.activity.viewModels
import androidx.core.app.ActivityOptionsCompat
import androidx.core.view.ViewCompat
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.saveo_assignment.R
import com.example.saveo_assignment.clickListeners.ImageClickListener
import com.example.saveo_assignment.databinding.ActivityMainBinding
import com.example.saveo_assignment.model.ShowsModel
import com.example.saveo_assignment.ui.adapter.MoviesAdapter
import com.example.saveo_assignment.ui.adapter.TrendingMoviesAdapter
import com.example.saveo_assignment.viewmodel.MoviesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), ImageClickListener {

     val viewModel by viewModels<MoviesViewModel>()
    private lateinit var binding: ActivityMainBinding
    private var moviesList = mutableListOf<ShowsModel>()
    private lateinit var moviesAdapter: MoviesAdapter
    private lateinit var trendingMoviesAdapter: TrendingMoviesAdapter
    var page = 0;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        /**
         * starting the shimmer effect
         */
        binding.apply {
            shimmerFrameLayout.startShimmerAnimation()
        }

        val layoutManager = GridLayoutManager(this, 3)
        setMoviesListRecycler(layoutManager)

        setTrendingMoviesRecycler()

        callApi(viewModel)

        pagination(layoutManager, viewModel, this)


    }

    /**
     * calling the api  here.
     */

    private fun callApi(viewModel: MoviesViewModel) {

        viewModel.getMoviesViewModel(1).observe(this, Observer {
            shimmerDisplay()
            moviesList.clear()
            val res = it.data!!
            moviesList.addAll(res)
            Log.d("lol", moviesList.size.toString())
            moviesAdapter.notifyDataSetChanged()
            trendingMoviesAdapter.notifyDataSetChanged()
        })
    }

    /**
     * setting the trending list recyclerview
     */

    private fun setTrendingMoviesRecycler() {
        binding.rvTrendingList.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        trendingMoviesAdapter = TrendingMoviesAdapter(moviesList, this)
        binding.rvTrendingList.adapter = trendingMoviesAdapter
    }

    /**
     * setting all the movie list recyclerview here
     */

    private fun setMoviesListRecycler(layoutManager: GridLayoutManager) {
        binding.rvMoviesList.layoutManager = layoutManager
        moviesAdapter = MoviesAdapter(moviesList, this)
        binding.rvMoviesList.adapter = moviesAdapter

    }

    /**
     * function for the pagination
     */

    private fun pagination(
        layoutManager: GridLayoutManager,
        viewModel: MoviesViewModel,
        mainActivity: MainActivity
    ) {
        var loading = true
        var pastVisibleItems: Int
        var visibleItemCount: Int
        var totalItemCount: Int
        binding.rvMoviesList.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if (dy > 0) { //check for scroll down
                    visibleItemCount = layoutManager.childCount
                    totalItemCount = layoutManager.itemCount
                    pastVisibleItems = layoutManager.findFirstVisibleItemPosition()
                    if (loading) {
                        if (visibleItemCount + pastVisibleItems >= totalItemCount) {
                            page++
                            loading = false
                            Log.v("...", "Last Item Wow ! $page")
                            viewModel.getMoviesViewModel(page).observe(mainActivity, {
                                val result = it.data!!
                                moviesList.addAll(result)
                                moviesAdapter.notifyDataSetChanged()

                            })
                            loading = true
                        }
                    }
                }
            }
        })
    }


    /**
     * function to display the shimmer effect
     */

    private fun shimmerDisplay() {
        binding.apply {
            shimmerFrameLayout.stopShimmerAnimation()
            shimmerFrameLayout.visibility = View.GONE
            rvMoviesList.visibility = View.VISIBLE
            rvTrendingList.visibility = View.VISIBLE
            tvNowShowing.visibility = View.VISIBLE
        }
        moviesList.clear()
    }

    /**
     * on click of each item its data will be passed to next activity through intent
     */

    override fun onImageClicked(showsModel: ShowsModel, mIvImage: ImageView) {
        val intent = Intent(this, MovieDetailsActivity::class.java)
        intent.putExtra("movies", showsModel)
        /**
         * this is to give animation effect to the image while passing data to the next activity
         */
        val options = ActivityOptionsCompat.makeSceneTransitionAnimation(
            this,
            mIvImage,
            ViewCompat.getTransitionName(mIvImage)!!
        )
        startActivity(intent, options.toBundle())
    }
}