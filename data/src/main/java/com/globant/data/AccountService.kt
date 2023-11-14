package com.globant.data

import com.globant.data.response.AccountResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface AccountService {
    @GET("account/{accountId}")
    suspend fun getAccountDetails(@Path("accountId") accountId: Int): AccountResponse
}
