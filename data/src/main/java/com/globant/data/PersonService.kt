package com.globant.data

import com.globant.data.response.BaseResponse
import com.globant.data.response.PersonResponse
import retrofit2.http.GET

interface PersonService {
    @GET("person/popular")
    suspend fun getPopularPeople(): BaseResponse<PersonResponse>
}
