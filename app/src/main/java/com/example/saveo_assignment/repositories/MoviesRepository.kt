package com.example.saveo_assignment.repositories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.example.saveo_assignment.model.ShowsModel
import com.example.saveo_assignment.network.APiService
import com.example.saveo_assignment.network.Resource
import com.example.saveo_assignment.network.ResponseHandler
import com.example.saveo_assignment.network.RetrofitGenerator
import com.example.saveo_assignment.pagination.MoviePagingSource
import java.lang.Exception

class MoviesRepository {

    private val api: APiService = RetrofitGenerator.getInstance().create(APiService::class.java)

    private val responseHandler = ResponseHandler()

    fun getIncrementedPageNumber() =
        Pager(
            config = PagingConfig(
                pageSize = 10,
                maxSize = 100,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { MoviePagingSource(api) }
        ).liveData

    suspend fun getTheMovie(page : Int): Resource<List<ShowsModel>> {
        val result = api.getMovies(page)
        try {
            return responseHandler.handleSuccess(result)
        } catch (e: Exception) {
            return responseHandler.handleException(e)
        }
    }
}