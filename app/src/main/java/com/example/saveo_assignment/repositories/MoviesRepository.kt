package com.example.saveo_assignment.repositories

import com.example.saveo_assignment.model.MoviesResponseModelItem
import com.example.saveo_assignment.model.ShowsModel
import com.example.saveo_assignment.network.APiService
import com.example.saveo_assignment.network.Resource
import com.example.saveo_assignment.network.ResponseHandler
import com.example.saveo_assignment.network.RetrofitGenerator
import java.lang.Exception

class MoviesRepository {

    private val api: APiService = RetrofitGenerator.getInstance().create(APiService::class.java)

    private val responseHandler = ResponseHandler()

    suspend fun getTheMovie(page: Int): Resource<List<ShowsModel>> {
        val result = api.getMovies(page)
        try {
            return responseHandler.handleSuccess(result)
        } catch (e: Exception) {
            return responseHandler.handleException(e)
        }
    }
}