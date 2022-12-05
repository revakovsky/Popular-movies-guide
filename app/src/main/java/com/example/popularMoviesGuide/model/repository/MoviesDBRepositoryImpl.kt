package com.example.popularMoviesGuide.model.repository

import com.example.popularMoviesGuide.data.models.moviesDetails.MovieDetails
import com.example.popularMoviesGuide.data.models.moviesList.DbResponseDto
import com.example.popularMoviesGuide.data.apis.ApiInterface
import retrofit2.Call

class MoviesDBRepositoryImpl : MoviesDBRepository {

    private val apiInterface = ApiInterface.create()

    override fun getMovies() : Call<DbResponseDto> {
        return apiInterface.getMovies(API_KEY, "en-US", 1)
    }

    override fun getMovieDetails(id : Int) : Call<MovieDetails> {
        return apiInterface.getMovieDetails(id, API_KEY)
    }

    companion object {
        private const val API_KEY: String = "248691836d283188a26679570aae0ef6"
    }
}