package com.ynov.kotlin.rickmorty.data.entity.mapper

import com.ynov.kotlin.rickmorty.data.entity.remote.EpisodeListRemoteEntity
import com.ynov.kotlin.rickmorty.data.entity.remote.EpisodeRemoteEntity
import com.ynov.kotlin.rickmorty.data.model.Episode

class EpisodeRemoteEntityDataMapper {

    fun transformFromRemoteEntity(episodeRemoteEntity: EpisodeRemoteEntity): Episode {
        return Episode(
            created = episodeRemoteEntity.created,
            id = episodeRemoteEntity.id,
            name = episodeRemoteEntity.name,
            url = episodeRemoteEntity.url,
            air_date = episodeRemoteEntity.air_date,
            characters = episodeRemoteEntity.characters,
            episode = episodeRemoteEntity.episode
        )
    }

    fun transformFromRemoteEntityList(episodeListRemoteEntity: EpisodeListRemoteEntity): List<Episode> {
        return episodeListRemoteEntity.episodeList.map {
            transformFromRemoteEntity(it)
        }
    }
}