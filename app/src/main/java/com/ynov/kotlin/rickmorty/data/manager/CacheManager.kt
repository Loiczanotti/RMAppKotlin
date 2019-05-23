package com.ynov.kotlin.rickmorty.data.manager

import com.ynov.kotlin.rickmorty.data.model.Character
import io.reactivex.Single

interface CacheManager {
    fun retrieveOneCharacterById(id: Int): Character?
    fun setCharacterList(characterList: List<Character>)
}