package com.ynov.kotlin.rickmorty.data

import com.ynov.kotlin.rickmorty.data.entity.mapper.CharacterRemoteEntityDataMapper
import com.ynov.kotlin.rickmorty.data.entity.remote.CharacterListRemoteEntity
import com.ynov.kotlin.rickmorty.data.manager.ApiManagerImpl
import com.ynov.kotlin.rickmorty.data.manager.CacheManager
import com.ynov.kotlin.rickmorty.data.manager.CacheManagerImpl
import com.ynov.kotlin.rickmorty.data.model.Character
import io.reactivex.Single
import java.lang.Exception

class DataRepository(
    private val apiManagerImpl: ApiManagerImpl,
    private val characterRemoteEntityDataMapper: CharacterRemoteEntityDataMapper,
    private val cacheManager: CacheManagerImpl
) {

    fun retrieveAllCharacterList(): Single<List<Character>> {
        return Single.defer {
            apiManagerImpl.retrieveCharacterList()
                .map {
                    characterRemoteEntityDataMapper.transformFromRemoteEntityList(it)
                }.doAfterSuccess {
                    cacheManager.setCharacterList(it)
                }
        }
    }


    fun retrieveOneCharacter(id: Int): Single<Character> {
        return Single.defer {
            cacheManager.retrieveOneCharacterById(id)?.let {
                return@let Single.just(it)
            } ?: run {
                return@run apiManagerImpl.retrieveOneCharacter(id).map {
                    characterRemoteEntityDataMapper.transformFromRemoteEntityList(it)
                }
            }
        }


    }


}
