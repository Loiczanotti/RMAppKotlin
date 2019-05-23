package com.ynov.kotlin.rickmorty.data.manager

import com.ynov.kotlin.rickmorty.data.model.Character
import io.reactivex.Single

class CacheManagerImpl: CacheManager{


    private val listCharacter: MutableList<Character> = mutableListOf()

    override fun retrieveOneCharacterById(id: Int): Character? {
        return listCharacter.first { it.id == id }
    }

    override fun setCharacterList(characterList: List<Character>) {
        listCharacter.clear()
        listCharacter.addAll(characterList)
    }




}