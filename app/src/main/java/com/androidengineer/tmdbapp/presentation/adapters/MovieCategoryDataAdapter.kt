package com.androidengineer.tmdbapp.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.androidengineer.tmdbapp.databinding.RowTopRatedMovieRecyclerBinding
import com.androidengineer.tmdbapp.domain.models.MovieData
import dagger.hilt.android.scopes.FragmentScoped
import javax.inject.Inject

@FragmentScoped
class MovieCategoryDataAdapter @Inject constructor():
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val moviesDataList = arrayListOf<MovieData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return DataViewHolder(RowTopRatedMovieRecyclerBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun getItemCount(): Int {
        return moviesDataList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as DataViewHolder).rowTopRatedMovieRecyclerBinding.movieData = moviesDataList.get(position)
    }

    inner class DataViewHolder(
        val rowTopRatedMovieRecyclerBinding: RowTopRatedMovieRecyclerBinding
        ): RecyclerView.ViewHolder(rowTopRatedMovieRecyclerBinding.root) {

    }

    fun updateData(list: ArrayList<MovieData>)
    {
        moviesDataList.addAll(list)
        notifyDataSetChanged()
    }
}