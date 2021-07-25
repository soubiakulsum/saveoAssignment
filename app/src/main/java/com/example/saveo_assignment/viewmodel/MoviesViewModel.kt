package com.example.saveo_assignment.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.saveo_assignment.model.MoviesResponseModelItem
import com.example.saveo_assignment.model.ShowsModel
import com.example.saveo_assignment.network.Resource
import com.example.saveo_assignment.repositories.MoviesRepository
import kotlinx.coroutines.Dispatchers

class MoviesViewModel(private val repository : MoviesRepository) : ViewModel() {


    fun getMoviesViewModel(page: Int): LiveData<Resource<List<ShowsModel>>> {
        return liveData(Dispatchers.IO) {
            val result = repository.getTheMovie(page)
            emit(result)
        }
    }
}