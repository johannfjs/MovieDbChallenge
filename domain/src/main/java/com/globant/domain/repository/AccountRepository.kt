package com.globant.domain.repository

import com.globant.domain.model.Account

interface AccountRepository {
    suspend fun getAccountDetails(accountId: Int): Account
}
