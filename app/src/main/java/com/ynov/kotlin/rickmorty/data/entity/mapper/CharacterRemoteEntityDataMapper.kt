package com.ynov.kotlin.rickmorty.data.entity.mapper

import com.ynov.kotlin.rickmorty.data.entity.remote.CharacterListRemoteEntity
import com.ynov.kotlin.rickmorty.data.entity.remote.CharacterRemoteEntity
import com.ynov.kotlin.rickmorty.data.model.Character

class CharacterRemoteEntityDataMapper (
    private val originRemoteEntityDataMapper: OriginRemoteEntityDataMapper,
    private val locationRemoteEntityDataMapper: LocationRemoteEntityDataMapper
){
    fun transformFromRemoteEntity(characterRemoteEntity: CharacterRemoteEntity): Character {
        return Character(
            created = characterRemoteEntity.created,
            episodes = characterRemoteEntity.episodes,
            gender = characterRemoteEntity.gender,
            id = characterRemoteEntity.id,
            image = characterRemoteEntity.image,
            location = locationRemoteEntityDataMapper.transformFromRemoteEntity(characterRemoteEntity.location),
            name = characterRemoteEntity.name,
            origin = originRemoteEntityDataMapper.transformFromRemoteEntity(characterRemoteEntity.origin),
            species = characterRemoteEntity.species,
            status = characterRemoteEntity.status,
            type = characterRemoteEntity.type,
            url = characterRemoteEntity.url
        )
    }

    fun transformFromRemoteEntity(characterRemoteEntityList: CharacterListRemoteEntity): List<Character> {
        return characterRemoteEntityList.characterList.map {
            transformFromRemoteEntity(it)
        }
    }
}