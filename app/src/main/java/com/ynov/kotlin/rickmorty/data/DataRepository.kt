package com.ynov.kotlin.rickmorty.data

import com.ynov.kotlin.rickmorty.data.entity.mapper.CharacterRemoteEntityDataMapper
import com.ynov.kotlin.rickmorty.data.manager.ApiManagerImpl
import com.ynov.kotlin.rickmorty.data.manager.ApiService
import com.ynov.kotlin.rickmorty.data.model.Character
import io.reactivex.Single

class DataRepository(
    private val apiManagerImpl: ApiManagerImpl,
    private val characterRemoteEntityDataMapper: CharacterRemoteEntityDataMapper
) {

    fun retrieveAllCharacterList(): Single<List<Character>> =
        apiManagerImpl.retrieveCharacterList().map {
            characterRemoteEntityDataMapper.transformFromRemoteEntity(it)
        }

}
