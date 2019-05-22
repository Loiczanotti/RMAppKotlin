package com.ynov.kotlin.rickmorty.data.entity.remote

import com.google.gson.annotations.SerializedName

data class CharacterListRemoteEntity (
    @SerializedName("results")
    val characterList: List<CharacterRemoteEntity> = emptyList()
)