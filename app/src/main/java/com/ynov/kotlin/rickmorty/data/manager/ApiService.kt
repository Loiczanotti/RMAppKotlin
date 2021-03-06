package com.ynov.kotlin.rickmorty.data.manager

import com.ynov.kotlin.rickmorty.data.entity.remote.CharacterListRemoteEntity
import com.ynov.kotlin.rickmorty.data.entity.remote.CharacterRemoteEntity
import com.ynov.kotlin.rickmorty.data.entity.remote.EpisodeListRemoteEntity
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("api/character/")
    fun retrieveAllCharacters(): Single<CharacterListRemoteEntity>

    @GET("api/character/{id}")
    fun retrieveOneCharacter(@Path("id") id: Int): Single<CharacterRemoteEntity>

    @GET("api/episode/")
    fun retrieveAllEpisodes(): Single<EpisodeListRemoteEntity>

}