package com.globant.feature.home.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.globant.domain.usecases.GetAccountDetailsByIdUseCase
import com.globant.domain.usecases.GetPersonPopularUseCase
import com.globant.feature.home.model.AccountModel
import com.globant.feature.home.model.PersonModel
import com.globant.feature.home.model.toModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val getAccountDetailsByIdUseCase: GetAccountDetailsByIdUseCase,
    private val getPersonPopularUseCase: GetPersonPopularUseCase,
) :
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

    private val _personPopular =
        MutableStateFlow<List<PersonModel>?>(emptyList())
    var personPopular: StateFlow<List<PersonModel>?> = _personPopular

    init {
        getAccountDetailsById(accountId = 20695928)
        getPersonPopular()
    }
    /*
        fun getPersonPopular() {
            viewModelScope.launch {
                getPersonPopularUseCase().onStart {
                }.catch {
                }.collect {
                    _personPopular.value = it.data?.map { it.toModel() }
                }
            }
        }

     */

    fun getPersonPopular() {
        viewModelScope.launch {
            while (true) {
                getPersonPopularUseCase().onStart {
                }.catch {
                }.collect {
                    _personPopular.value = it.data?.map { it.toModel() }?.shuffled()
                }
                delay(5000)
            }
        }
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
