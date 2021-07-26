package com.example.saveo_assignment.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.saveo_assignment.model.ShowsModel
import com.example.saveo_assignment.network.Resource
import com.example.saveo_assignment.repositories.MoviesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(private val repository : MoviesRepository) : ViewModel() {

    /**
     * calling the get getMoviesList from repository and returning the livedata, the resource class
     * is wrapping the data and returning livedata.
     */
    fun getMoviesViewModel(page : Int): LiveData<Resource<List<ShowsModel>>> {
        return liveData(Dispatchers.IO) {
            val result = repository.getMoviesList(page)
            emit(result)
        }
    }
}