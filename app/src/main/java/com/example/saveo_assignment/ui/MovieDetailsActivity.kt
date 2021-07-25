package com.example.saveo_assignment.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.saveo_assignment.R
import com.example.saveo_assignment.databinding.ActivityMovieDetailsBinding

class MovieDetailsActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMovieDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)
    }
}