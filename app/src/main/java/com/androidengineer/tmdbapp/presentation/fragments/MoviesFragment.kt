package com.androidengineer.tmdbapp.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.androidengineer.tmdbapp.R
import com.androidengineer.tmdbapp.databinding.FragmentMoviesBinding
import com.androidengineer.tmdbapp.presentation.adapters.MoviesCategoryPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MoviesFragment : Fragment() {

    private lateinit var moviesBinding: FragmentMoviesBinding
    private lateinit var moviesCategoryPagerAdapter: MoviesCategoryPagerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        moviesBinding = FragmentMoviesBinding.inflate(layoutInflater)
        return moviesBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity?.let { activityInstance ->
            moviesCategoryPagerAdapter = MoviesCategoryPagerAdapter(activityInstance)
            moviesBinding.moviesTabDataAdapter = moviesCategoryPagerAdapter
            moviesBinding.viewPager.post {
                TabLayoutMediator(
                    moviesBinding.tabLayout,
                    moviesBinding.viewPager
                ) { tab, position ->
                    when (position) {
                        0-> tab.text = getString(R.string.text_popular_tab)
                        1-> tab.text = getString(R.string.text_nowplaying_tab)
                        2-> tab.text = getString(R.string.text_upcoming_tab)
                        3-> tab.text = getString(R.string.text_toprated_tab)
                    }
                }.attach()
            }
        }
    }
}