package com.globant.feature.home.model

import com.globant.domain.model.Account

data class AccountModel(val name: String, val username: String, val includeAdult: Boolean)

fun Account.toModel(): AccountModel =
    AccountModel(
        name = name,
        username = username,
        includeAdult = includeAdult,
    )
