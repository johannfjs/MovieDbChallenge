package com.globant.navigation.utils

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument

private const val TITLE_RES_ARG_KEY = "title_res"
const val TITLE_TXT_ARG_KEY = "title_txt"

fun String.appendTitleParams() = this.appendQueryParam(TITLE_RES_ARG_KEY, "{$TITLE_RES_ARG_KEY}")
    .appendQueryParam(TITLE_TXT_ARG_KEY, "{$TITLE_TXT_ARG_KEY}")

fun List<NamedNavArgument>.appendTitleNavArguments() = this + listOf(
    navArgument(TITLE_RES_ARG_KEY) { type = NavType.ReferenceType; defaultValue = 0 },
    navArgument(TITLE_TXT_ARG_KEY) { nullable = true },
)

private fun String.appendQueryParam(key: String, value: String): String {
    val separator = if ("?" in this) "&" else "?"
    return "$this$separator$key=$value"
}
