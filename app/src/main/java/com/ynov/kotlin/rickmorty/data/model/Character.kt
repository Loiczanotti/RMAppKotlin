package com.ynov.kotlin.rickmorty.data.model

data class Character (
    val id: Int = 0,
    val name: String = "",
    val status: String = "",
    val species: String = "",
    val type: String = "",
    val gender: String = "",
    val origin: Origin = Origin(),
    val location: Location = Location(),
    val image: String = "",
    val episodes: List<String> = emptyList(),
    val url: String = "",
    val created: String = ""
)