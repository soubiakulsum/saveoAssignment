package com.example.saveo_assignment.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import com.example.saveo_assignment.R
import com.example.saveo_assignment.databinding.ActivityMovieDetailsBinding
import com.example.saveo_assignment.model.ShowsModel
import org.jsoup.Jsoup

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

    /**
     * getting all the data through intent from previous activity and setting the data to respective views
     */
    private fun getData() {
        if (intent != null && intent.extras != null) {
            showsModel = intent.getSerializableExtra("movies") as ShowsModel

            Glide.with(this).load(showsModel.image?.original).into(binding.ivMovieThumbnail)

            val textFromHtml: String = Jsoup.parse(showsModel.summary).text()

            binding.tvSynopsisData.text = textFromHtml

            if (showsModel.rating?.average != null) {
                /**
                 * setting all the data coming from the api to its respective views
                 */
                binding.apply {
                    tvMovieName.text = showsModel.name
                    tvTime.text = showsModel.premiered.toString()
                    tvRatings.text = showsModel.rating.toString()
                    tvReview.text = " imdb : ${showsModel.externals?.imdb}"
                    tvStarRating.visibility = View.VISIBLE
                    starRatingBar.visibility = View.VISIBLE
                    tvStarRating.text = showsModel.rating!!.average.toString()
                    starRatingBar.rating = showsModel.rating!!.average.toString().toFloat() / 2
                }

            }

            /**
             * the below code is to set the list of different genres of data accordingly.
             */

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