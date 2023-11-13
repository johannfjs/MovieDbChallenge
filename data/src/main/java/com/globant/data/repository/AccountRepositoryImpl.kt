package com.globant.data.repository

import com.globant.data.AccountService
import com.globant.data.response.toDomain
import com.globant.domain.model.Account
import com.globant.domain.repository.AccountRepository
import javax.inject.Inject

class AccountRepositoryImpl @Inject constructor(private val accountService: AccountService) : AccountRepository {
    override suspend fun getAccountDetails(accountId: Int): Account {
        return accountService.getAccountDetails(accountId).toDomain()
    }
}
