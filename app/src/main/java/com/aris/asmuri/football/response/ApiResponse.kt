package com.aris.asmuri.football.response

import com.google.gson.annotations.SerializedName

data class ListResponse<T>(
    @SerializedName("leagues")
    val result: List<T>? = null
)

data class ListResponseMatch<T>(
    @SerializedName("events")
    val result: List<T>? = null
)

data class ListResponseTeam<T>(
    @SerializedName("teams")
    val result: List<T>? = null
)

data class ListResponseSearchMatch<T>(
    @SerializedName("event")
    val result: List<T>? = null
)

data class ListResponseFootballStanding<T>(
    @SerializedName("table")
    val result: List<T>? = null
)