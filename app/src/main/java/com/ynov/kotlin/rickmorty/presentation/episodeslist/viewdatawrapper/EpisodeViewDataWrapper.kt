package com.ynov.kotlin.rickmorty.presentation.episodeslist.viewdatawrapper

import com.ynov.kotlin.rickmorty.data.model.Episode

class EpisodeViewDataWrapper(private val episode: Episode) {

    fun getName(): String = episode.name
    fun getId(): Int = episode.id
    fun getDate(): String = episode.air_date
    fun getEpisode(): String = episode.episode
}