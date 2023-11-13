package com.globant.data.response

import com.google.gson.annotations.SerializedName

data class AvatarResponse(
    @SerializedName("gravatar")
    val gravatar: GravatarResponse,
    @SerializedName("tmdb")
    val tmdb: TmdbResponse,
)
