package com.ynov.kotlin.rickmorty.data.entity.remote

import com.google.gson.annotations.SerializedName

data class CharacterRemoteEntity (
    @SerializedName("id") val id: Int = 0,
     @SerializedName("name") val name: String = "",
     @SerializedName("status") val status: String = "",
     @SerializedName("species") val species: String = "",
     @SerializedName("type") val type: String = "",
     @SerializedName("gender") val gender: String = "",
     @SerializedName("origin") val origin: OriginRemoteEntity = OriginRemoteEntity(),
     @SerializedName("location") val location: LocationRemoteEntity = LocationRemoteEntity(),
     @SerializedName("image") val image: String = "",
     @SerializedName("episodes") val episodes: List<String> = emptyList(),
     @SerializedName("url") val url: String = "",
     @SerializedName("created") val created: String = ""
)