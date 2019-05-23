package com.ynov.kotlin.rickmorty.data.model

data class Episode (
    val id: Int = 0,
    val name: String = "",
    val air_date: String = "",
    val episode: String = "",
    val characters: List<String> = emptyList(),
    val url: String = "",
    val created: String = ""
)