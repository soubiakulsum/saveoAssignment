package com.example.saveo_assignment.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import com.example.saveo_assignment.R
import com.example.saveo_assignment.databinding.ActivityMovieDetailsBinding
import com.example.saveo_assignment.model.ShowsModel

class MovieDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMovieDetailsBinding
    private lateinit var showsModel: ShowsModel



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)
        binding = ActivityMovieDetailsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        getData()

    }

    private fun getData() {
        if (intent != null && intent.extras != null) {
            showsModel = intent.getSerializableExtra("movies") as ShowsModel
            binding.tvMovieName.text = showsModel.name
            Glide.with(this).load(showsModel.image?.original).into(binding.ivMovieThumbnail)
            binding.tvTime.text = showsModel.premiered.toString()
            binding.tvRatings.text = showsModel.rating.toString()
            binding.tvReview.text = " imdb : ${showsModel.externals?.imdb}"
            binding.tvSynopsisData.text = showsModel.summary

            if (showsModel.rating?.average != null) {
                binding.tvStarRating.visibility = View.VISIBLE
                binding.starRatingBar.visibility = View.VISIBLE
                binding.tvStarRating.text = showsModel.rating!!.average.toString()
                binding.starRatingBar.rating = showsModel.rating!!.average.toString().toFloat() / 2
            }

            if (showsModel.genres!!.isNotEmpty()) {
                when (showsModel.genres!!.size) {
                    1 -> {
                        binding.apply {
                            tvGenre1.visibility = View.VISIBLE
                            tvGenre1.text = showsModel.genres!![0]
                        }
                    }
                    2 -> {
                        binding.apply {
                            tvGenre1.visibility = View.VISIBLE
                            tvGenre1.text = showsModel.genres!![0]
                            tvGenre2.visibility = View.VISIBLE
                            tvGenre2.text = showsModel.genres!![1]
                        }
                    }
                    3 -> {
                        binding.apply {
                            tvGenre1.visibility = View.VISIBLE
                            tvGenre1.text = showsModel.genres!![0]
                            tvGenre2.visibility = View.VISIBLE
                            tvGenre2.text = showsModel.genres!![1]
                            tvGenre3.visibility = View.VISIBLE
                            tvGenre3.text = showsModel.genres!![2]
                        }
                    }
                    else -> {
                        binding.apply {
                            tvGenre1.visibility = View.VISIBLE
                            tvGenre1.text = showsModel.genres!![0]
                            tvGenre2.visibility = View.VISIBLE
                            tvGenre2.text = showsModel.genres!![1]
                            tvGenre3.visibility = View.VISIBLE
                            tvGenre3.text = showsModel.genres!![2]
                            tvGenre4.visibility = View.VISIBLE
                            tvGenre4.text = showsModel.genres!![3]
                        }
                    }
                }
            }

        }
    }
}