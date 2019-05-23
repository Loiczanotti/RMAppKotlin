package com.ynov.kotlin.rickmorty.data.entity.remote

import com.google.gson.annotations.SerializedName

data class EpisodeRemoteEntity(

    @SerializedName("id") val id: Int = 0,
    @SerializedName("name") val name: String = "",
    @SerializedName("air_date") val air_date: String = "",
    @SerializedName("episode") val episode: String = "",
    @SerializedName("characters") val characters: List<String> = emptyList(),
    @SerializedName("url") val url: String = "",
    @SerializedName("created") val created: String = ""
)