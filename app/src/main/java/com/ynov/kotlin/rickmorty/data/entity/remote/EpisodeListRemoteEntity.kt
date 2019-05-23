package com.ynov.kotlin.rickmorty.data.entity.remote

import com.google.gson.annotations.SerializedName

data class EpisodeListRemoteEntity (
    @SerializedName("results")
    val episodeList: List<EpisodeRemoteEntity> = emptyList()
)