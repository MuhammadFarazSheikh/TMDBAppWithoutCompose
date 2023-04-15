package com.androidengineer.tmdbapp.presentation.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.androidengineer.tmdbapp.presentation.fragments.MoviesCategoryDataFragment
import dagger.hilt.android.scopes.FragmentScoped

@FragmentScoped
class MoviesCategoryPagerAdapter (fragmentActivity: FragmentActivity): FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return 4
    }

    override fun createFragment(position: Int): Fragment {
        return MoviesCategoryDataFragment.getInstance(position)
    }
}