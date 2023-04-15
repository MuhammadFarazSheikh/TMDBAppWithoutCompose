package com.androidengineer.tmdbapp.domain.models

data class MoviesList(
    val page:Int,
    val results:ArrayList<MovieData>,
    val total_pages:Int,
    val total_results:Int
)