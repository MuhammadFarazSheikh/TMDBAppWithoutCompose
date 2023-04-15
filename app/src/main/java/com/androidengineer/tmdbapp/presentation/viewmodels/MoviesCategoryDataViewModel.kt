package com.androidengineer.tmdbapp.presentation.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.androidengineer.tmdbapp.domain.models.MovieData
import com.androidengineer.tmdbapp.domain.repositories.MoviesCategoryDataRepository
import com.androidengineer.tmdbapp.domain.repositories.models.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoviesCategoryDataViewModel @Inject constructor(
    private val moviesCategoryDataRepository: MoviesCategoryDataRepository
) : ViewModel() {

    val moviesDataListLiveData = MutableLiveData<ArrayList<MovieData>>()

    fun callApiToGetPopularMoviesList(apiKey: String) = viewModelScope.launch {
        val apiCallResponse = moviesCategoryDataRepository.callApiToGetPopularMoviesList(apiKey)
        when (apiCallResponse) {
            is Resource.Success -> {
                moviesDataListLiveData.value=apiCallResponse.value.results
            }
            is Resource.Failure -> {
                moviesDataListLiveData.value = arrayListOf()
            }
            is Resource.Loading -> {

            }
        }
    }

    fun callApiToGetNowPlayingMoviesList(apiKey: String) = viewModelScope.launch {
        val apiCallResponse = moviesCategoryDataRepository.callApiToGetNowPlayingMoviesList(apiKey)
        when (apiCallResponse) {
            is Resource.Success -> {
                moviesDataListLiveData.value=apiCallResponse.value.results
            }
            is Resource.Failure -> {
                moviesDataListLiveData.value = arrayListOf()
            }
            is Resource.Loading -> {

            }
        }
    }

    fun callApiToGetUpComingMoviesList(apiKey: String) = viewModelScope.launch {
        val apiCallResponse = moviesCategoryDataRepository.callApiToGetUpComingMoviesList(apiKey)
        when (apiCallResponse) {
            is Resource.Success -> {
                moviesDataListLiveData.value=apiCallResponse.value.results
            }
            is Resource.Failure -> {
                moviesDataListLiveData.value = arrayListOf()
            }
            is Resource.Loading -> {

            }
        }
    }

    fun callApiToGetTopRatedMoviesList(apiKey: String) = viewModelScope.launch {
        val apiCallResponse = moviesCategoryDataRepository.callApiToGetTopRatedMoviesList(apiKey)
        when (apiCallResponse) {
            is Resource.Success -> {
                moviesDataListLiveData.value=apiCallResponse.value.results
            }
            is Resource.Failure -> {
                moviesDataListLiveData.value = arrayListOf()
            }
            is Resource.Loading -> {

            }
        }
    }
}