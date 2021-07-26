package com.example.saveo_assignment.repositories

import com.example.saveo_assignment.model.ShowsModel
import com.example.saveo_assignment.network.APiService
import com.example.saveo_assignment.network.Resource
import com.example.saveo_assignment.network.ResponseHandler
import java.lang.Exception
import javax.inject.Inject


class MoviesRepository  @Inject constructor(val aPiService: APiService){

    private val responseHandler = ResponseHandler()

    /**
     * calling the function from ApiService and returning the resource list handling the
     * success and exception if there are any.
     */
    suspend fun getMoviesList(page : Int): Resource<List<ShowsModel>> {
        val result = aPiService.getMovies(page)
        try {
            return responseHandler.handleSuccess(result)
        } catch (e: Exception) {
            return responseHandler.handleException(e)
        }
    }
}