package com.ynov.kotlin.rickmorty.presentation.viewdatawrapper

import com.ynov.kotlin.rickmorty.data.model.Character
import com.ynov.kotlin.rickmorty.data.model.Location
import com.ynov.kotlin.rickmorty.data.model.Origin

class CharacterViewDataWrapper(val character: Character) {
    fun getId(): Int = character.id
    fun getName(): String = character.name
    fun getStatus(): String = character.status
    fun getSpecies(): String = character.species
    fun getGender(): String = character.gender
    fun getImage(): String = character.image
    fun getOrigin(): Origin = character.origin
    fun getLocation(): Location = character.location
    fun getCreated(): String = character.created
}