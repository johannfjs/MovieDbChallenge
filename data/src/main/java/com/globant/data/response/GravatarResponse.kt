package com.globant.data.response

import com.google.gson.annotations.SerializedName

data class GravatarResponse(
    @SerializedName("hash")
    val hash: String,
)
