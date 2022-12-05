package com.example.popularMoviesGuide.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.popularMoviesGuide.data.models.moviesDetails.MovieDetails
import com.example.popularMoviesGuide.data.models.moviesList.DbResponseDto
import com.example.popularMoviesGuide.data.models.moviesList.MovieDto
import com.example.popularMoviesGuide.model.repository.MoviesDBRepository
import com.example.popularMoviesGuide.model.repository.MoviesDBRepositoryImpl
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MoviesViewModel {

    private val _movies = MutableLiveData<List<MovieDto?>>()
    val movies: LiveData<List<MovieDto?>> = _movies

    private val _movieDetails = MutableLiveData<MovieDetails>()
    val movieDetails: LiveData<MovieDetails> = _movieDetails

    private val moviesRepository: MoviesDBRepository = MoviesDBRepositoryImpl()

    private val _errorMessage = MutableLiveData<ErrorHandler<String>>()
    val errorMessage: LiveData<ErrorHandler<String>>
        get() = _errorMessage

    fun getMovies() {
        val response = moviesRepository.getMovies()
        response.enqueue(object : Callback<DbResponseDto> {
            override fun onResponse(
                call: Call<DbResponseDto>,
                response: Response<DbResponseDto>
            ) {
                _movies.postValue(response.body()?.results)
            }

            override fun onFailure(call: Call<DbResponseDto>, t: Throwable) {
                _errorMessage.value = ErrorHandler("fail ${t.message}")
            }
        })
    }

    fun getMovieDetails(id: Int) {
        val response = moviesRepository.getMovieDetails(id)
        response.enqueue(object : Callback<MovieDetails> {
            override fun onResponse(call: Call<MovieDetails>, response: Response<MovieDetails>) {
                _movieDetails.postValue(response.body())
            }

            override fun onFailure(call: Call<MovieDetails>, t: Throwable) {
                _errorMessage.value = ErrorHandler("fail ${t.message}")
            }
        })
    }
}