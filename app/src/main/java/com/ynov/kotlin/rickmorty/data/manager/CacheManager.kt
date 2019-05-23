package com.ynov.kotlin.rickmorty.data.manager

import com.ynov.kotlin.rickmorty.data.model.Character
import com.ynov.kotlin.rickmorty.data.model.Episode
import io.reactivex.Single

interface CacheManager {
    fun retrieveOneCharacterById(id: Int): Character?
    fun setCharacterList(characterList: List<Character>)
    fun setEpisodeList(episodeList: List<Episode>)
}