package com.example.saveo_assignment.pagination

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.saveo_assignment.model.ShowsModel
import com.example.saveo_assignment.network.APiService

class MoviePagingSource(
    private val apiService: APiService
) : PagingSource<Int, ShowsModel>() {
    private val START_PAGE = 1

    override fun getRefreshKey(state: PagingState<Int, ShowsModel>): Int? {
        TODO("Not yet implemented")
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ShowsModel> {
        val postion = params.key ?: START_PAGE
        return try {
            val response = apiService.getMovies(postion)
            LoadResult.Page(
                data = response,
                prevKey = if (postion == START_PAGE) null else postion - 1,
                nextKey = if (response.isEmpty()) null else postion + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}