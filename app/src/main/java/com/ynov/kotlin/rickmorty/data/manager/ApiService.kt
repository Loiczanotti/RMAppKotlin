package com.ynov.kotlin.rickmorty.data.manager

import com.ynov.kotlin.rickmorty.data.entity.remote.CharacterListRemoteEntity
import io.reactivex.Single
import retrofit2.http.GET

interface ApiService {

    @GET("api/character/")
    fun retrieveCharacterList (): Single<CharacterListRemoteEntity>
}