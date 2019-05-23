package com.ynov.kotlin.rickmorty.data.manager

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

private const val API_BASE_URL = "https://rickandmortyapi.com/"

class ApiManagerImpl {

    private var apiService: ApiService = Retrofit.Builder()
        .baseUrl(API_BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(ApiService::class.java)

    fun retrieveAllCharacters() = apiService.retrieveAllCharacters()
    fun retrieveOneCharacter(id: Int) = apiService.retrieveOneCharacter(id)
    fun retrieveAllEpisodes() = apiService.retrieveAllEpisodes()
}