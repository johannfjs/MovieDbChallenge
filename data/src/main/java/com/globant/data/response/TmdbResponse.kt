package com.globant.data.response

import com.google.gson.annotations.SerializedName

data class TmdbResponse(
    @SerializedName("avatar_path")
    val avatarPath: Any,
)
