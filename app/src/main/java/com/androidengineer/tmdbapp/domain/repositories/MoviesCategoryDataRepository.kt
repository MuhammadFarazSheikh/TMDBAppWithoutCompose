package com.androidengineer.tmdbapp.domain.repositories

import com.androidengineer.tmdbapp.data.remote.TMDBApiService
import javax.inject.Inject

class MoviesCategoryDataRepository @Inject constructor(
    private val tmdbApiService: TMDBApiService
) : BaseRepository() {

    suspend fun callApiToGetPopularMoviesList(apiKey: String) = safeApiCall {
        tmdbApiService.callPopularMoviesListApi(apiKey)
    }

    suspend fun callApiToGetNowPlayingMoviesList(apiKey: String) = safeApiCall {
        tmdbApiService.callNowPlayingMoviesListApi(apiKey)
    }

    suspend fun callApiToGetUpComingMoviesList(apiKey:String)=safeApiCall {
        tmdbApiService.callUpcomingMoviesListApi(apiKey)
    }

    suspend fun callApiToGetTopRatedMoviesList(apiKey:String)=safeApiCall {
        tmdbApiService.callTopRatedMoviesListApi(apiKey)
    }
}