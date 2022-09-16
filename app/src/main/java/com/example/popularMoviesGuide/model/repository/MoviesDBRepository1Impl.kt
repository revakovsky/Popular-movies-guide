package com.example.popularMoviesGuide.model.repository

import com.example.popularMoviesGuide.Constants
import com.example.popularMoviesGuide.data.MovieDetails
import com.example.popularMoviesGuide.data.MoviesDataBase
import com.example.popularMoviesGuide.model.apis.ApiInterface
import retrofit2.Call

/**
 * Repository provides info taken from MovieDB API
**/

class MoviesDBRepository1Impl : MoviesDBRepository1 {

    //include retrofit in our code
    private val apiInterface = ApiInterface.create()

    override fun getMovies() : Call<MoviesDataBase> {
        return apiInterface.getMovies(Constants.API_KEY, "en-US", 1)
    }

    override fun getMovieDetails(id : Int) : Call<MovieDetails> {
        return apiInterface.getMovieDetails(id, Constants.API_KEY)
    }
}