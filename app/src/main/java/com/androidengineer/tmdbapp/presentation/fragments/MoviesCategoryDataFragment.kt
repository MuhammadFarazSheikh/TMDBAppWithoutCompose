package com.androidengineer.tmdbapp.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.androidengineer.tmdbapp.databinding.FragmentMoviesCategoryDataBinding
import com.androidengineer.tmdbapp.others.Constants.MOVIES_LIST_API_KEY
import com.androidengineer.tmdbapp.presentation.adapters.MovieCategoryDataAdapter
import com.androidengineer.tmdbapp.presentation.viewmodels.MoviesCategoryDataViewModel
import com.androidengineer.tmdbapp.utils.Utils.MOVIES_TAB_POSITION
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MoviesCategoryDataFragment : Fragment() {

    @Inject lateinit var moviesMovieCategoryDataAdapter:MovieCategoryDataAdapter
    private val moviesCategoryDataViewModel:MoviesCategoryDataViewModel by viewModels()
    private lateinit var moviesCategoryDataBinding: FragmentMoviesCategoryDataBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        moviesCategoryDataBinding = FragmentMoviesCategoryDataBinding.inflate(layoutInflater)
        return moviesCategoryDataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        moviesCategoryDataBinding.moviesCategoryDataAdapter = moviesMovieCategoryDataAdapter
        when(arguments?.getInt(MOVIES_TAB_POSITION))
        {
            0-> moviesCategoryDataViewModel.callApiToGetPopularMoviesList(MOVIES_LIST_API_KEY)
            1-> moviesCategoryDataViewModel.callApiToGetNowPlayingMoviesList(MOVIES_LIST_API_KEY)
            2-> moviesCategoryDataViewModel.callApiToGetUpComingMoviesList(MOVIES_LIST_API_KEY)
            3-> moviesCategoryDataViewModel.callApiToGetTopRatedMoviesList(MOVIES_LIST_API_KEY)
        }
        moviesCategoryDataViewModel.moviesDataListLiveData.observe(viewLifecycleOwner)
        {movieDataList->
            movieDataList
            moviesMovieCategoryDataAdapter.updateData(movieDataList)
        }
    }

    companion object {
        fun getInstance(position:Int)=MoviesCategoryDataFragment().apply {
            arguments = Bundle().apply {
                putInt(MOVIES_TAB_POSITION,position)
            }
        }
    }
}