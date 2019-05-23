package com.ynov.kotlin.rickmorty.data.manager

import com.ynov.kotlin.rickmorty.data.model.Character
import com.ynov.kotlin.rickmorty.data.model.Episode

class CacheManagerImpl: CacheManager{

    private val characterList: MutableList<Character> = mutableListOf()
    private val episodeList: MutableList<Episode> = mutableListOf()

    override fun retrieveOneCharacterById(id: Int): Character? {
        return characterList.first { it.id == id }
    }

    override fun setCharacterList(characterList: List<Character>) {
        this.characterList.clear()
        this.characterList.addAll(characterList)
    }

    override fun setEpisodeList(episodeList: List<Episode>) {
        this.episodeList.clear()
        this.episodeList.addAll(episodeList)
    }

    override fun retrieveAllCharacters(): List<Character> = characterList

    override fun retrieveAllEpisodes(): List<Episode> = episodeList

}