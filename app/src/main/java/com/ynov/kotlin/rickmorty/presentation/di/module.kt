package com.ynov.kotlin.rickmorty.presentation.di

import com.ynov.kotlin.rickmorty.data.DataRepository
import com.ynov.kotlin.rickmorty.data.entity.mapper.CharacterRemoteEntityDataMapper
import com.ynov.kotlin.rickmorty.data.entity.mapper.LocationRemoteEntityDataMapper
import com.ynov.kotlin.rickmorty.data.entity.mapper.OriginRemoteEntityDataMapper
import com.ynov.kotlin.rickmorty.data.manager.ApiManagerImpl
import com.ynov.kotlin.rickmorty.presentation.view.model.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val myModule = module {
    single { DataRepository(get(), get()) }
        single { CharacterRemoteEntityDataMapper(get(), get()) }
    single { OriginRemoteEntityDataMapper() }
    single { LocationRemoteEntityDataMapper() }
    single { ApiManagerImpl() }
    viewModel { HomeViewModel(get()) }
}
