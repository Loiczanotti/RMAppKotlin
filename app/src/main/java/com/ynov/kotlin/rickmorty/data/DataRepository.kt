package com.ynov.kotlin.rickmorty.data

import com.ynov.kotlin.rickmorty.data.entity.mapper.CharacterRemoteEntityDataMapper
import com.ynov.kotlin.rickmorty.data.entity.mapper.EpisodeRemoteEntityDataMapper
import com.ynov.kotlin.rickmorty.data.manager.ApiManagerImpl
import com.ynov.kotlin.rickmorty.data.manager.CacheManagerImpl
import com.ynov.kotlin.rickmorty.data.model.Character
import com.ynov.kotlin.rickmorty.data.model.Episode
import io.reactivex.Single

class DataRepository(
    private val apiManagerImpl: ApiManagerImpl,
    private val characterRemoteEntityDataMapper: CharacterRemoteEntityDataMapper,
    private val cacheManager: CacheManagerImpl,
    private val episodeRemoteEntityDataMapper: EpisodeRemoteEntityDataMapper
) {

    fun retrieveAllCharacterList(): Single<List<Character>> {
        return Single.defer {
            apiManagerImpl.retrieveAllCharacters()
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
                    characterRemoteEntityDataMapper.transformFromRemoteEntity(it)
                }
            }
        }

    }

    fun retrieveAllEpisodes(): Single<List<Episode>> {
        return Single.defer {
            apiManagerImpl.retrieveAllEpisodes()
                .map {
                    episodeRemoteEntityDataMapper.transformFromRemoteEntityList(it)
                }.doAfterSuccess {
                    cacheManager.setEpisodeList(it)
                }
        }
    }




}
