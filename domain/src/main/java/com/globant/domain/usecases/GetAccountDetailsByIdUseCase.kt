package com.globant.domain.usecases

import com.globant.domain.Resource
import com.globant.domain.repository.AccountRepository
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetAccountDetailsByIdUseCase @Inject constructor(private val accountRepository: AccountRepository) {
    operator fun invoke(accountId: Int) = flow {
        try {
            val result = accountRepository.getAccountDetails(accountId = accountId)
            emit(Resource.Success(result))
        } catch (e: Exception) {
            emit(Resource.Error("Connection Failed"))
        }
    }
}
