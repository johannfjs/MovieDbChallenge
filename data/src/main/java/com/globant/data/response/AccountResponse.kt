package com.globant.data.response

import com.globant.domain.model.Account
import com.google.gson.annotations.SerializedName

data class AccountResponse(
    @SerializedName("avatar")
    val avatar: AvatarResponse,
    @SerializedName("id")
    val id: Int,
    @SerializedName("include_adult")
    val includeAdult: Boolean,
    @SerializedName("iso_3166_1")
    val iso31661: String,
    @SerializedName("iso_639_1")
    val iso6391: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("username")
    val username: String,
)

fun AccountResponse.toDomain(): Account =
    Account(
        name = name,
        username = username,
        includeAdult = includeAdult,
    )
