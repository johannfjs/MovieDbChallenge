package com.globant.feature.home.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.globant.domain.usecases.GetAccountDetailsByIdUseCase
import com.globant.feature.home.model.AccountModel
import com.globant.feature.home.model.toModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(private val getAccountDetailsByIdUseCase: GetAccountDetailsByIdUseCase) :
    ViewModel() {

    private val _account =
        MutableStateFlow<AccountModel?>(
            AccountModel(
                name = "",
                username = "",
                includeAdult = false,
            ),
        )
    var account: StateFlow<AccountModel?> = _account

    init {
        getAccountDetailsById(accountId = 20695928)
    }

    fun getAccountDetailsById(accountId: Int) {
        viewModelScope.launch {
            getAccountDetailsByIdUseCase(accountId = accountId).onStart {
            }.catch {
            }.collect {
                _account.value = it.data?.toModel()
            }
        }
    }
}
