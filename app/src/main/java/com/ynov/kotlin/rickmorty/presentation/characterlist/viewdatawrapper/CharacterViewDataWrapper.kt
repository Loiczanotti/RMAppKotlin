package com.ynov.kotlin.rickmorty.presentation.characterlist.viewdatawrapper

import com.ynov.kotlin.rickmorty.data.model.Character

class CharacterViewDataWrapper(val character: Character) {
    fun getId(): Int = character.id
    fun getName(): String = character.name
    fun getStatus(): String = character.status
    fun getSpecies(): String = character.species
    fun getGender(): String = character.gender
    fun getImage(): String = character.image
    fun getOriginName(): String = character.origin.name
    fun getLocationName(): String = character.location.name
    fun getCreated(): String = character.created
}