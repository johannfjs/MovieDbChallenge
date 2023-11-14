package com.globant.data

import com.globant.data.response.BaseResponse
import com.globant.data.response.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieService {

    @GET("movie/popular")
    suspend fun getPopularMovies(): BaseResponse<MovieResponse>?

    @GET("movie/top_rated")
    suspend fun getTopRatedMovies(): BaseResponse<MovieResponse>?

    @GET("trending/movie/{timeWindow}")
    suspend fun getRecommendations(@Path("timeWindow") timeWindow: String): BaseResponse<MovieResponse>?
}
