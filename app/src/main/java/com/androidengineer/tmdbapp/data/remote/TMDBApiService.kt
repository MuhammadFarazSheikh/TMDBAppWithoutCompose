package com.androidengineer.tmdbapp.data.remote

import com.androidengineer.tmdbapp.domain.models.MoviesList
import com.androidengineer.tmdbapp.others.Constants.NOW_PLAYING_MOVIES
import com.androidengineer.tmdbapp.others.Constants.POPULAR_MOVIES
import com.androidengineer.tmdbapp.others.Constants.TOP_RATED_MOVIES
import com.androidengineer.tmdbapp.others.Constants.UPCOMING_MOVIES
import retrofit2.http.GET
import retrofit2.http.Query

interface TMDBApiService {
    @GET(POPULAR_MOVIES)
    suspend fun callPopularMoviesListApi(
        @Query("api_key") api_key: String,
    ):MoviesList

    @GET(NOW_PLAYING_MOVIES)
    suspend fun callNowPlayingMoviesListApi(
        @Query("api_key") api_key: String,
    ):MoviesList

    @GET(UPCOMING_MOVIES)
    suspend fun callUpcomingMoviesListApi(
        @Query("api_key") api_key: String,
    ):MoviesList

    @GET(TOP_RATED_MOVIES)
    suspend fun callTopRatedMoviesListApi(
        @Query("api_key") api_key: String,
    ):MoviesList
}