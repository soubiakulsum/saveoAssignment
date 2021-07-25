package com.example.saveo_assignment.network

import com.example.saveo_assignment.model.ShowsModel
import retrofit2.http.GET
import retrofit2.http.Query

interface APiService {
    @GET("shows")
    suspend fun getMovies(
        @Query("page") id : Int
    ): List<ShowsModel>


}