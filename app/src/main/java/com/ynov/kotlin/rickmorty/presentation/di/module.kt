package com.ynov.kotlin.rickmorty.presentation.di

import com.ynov.kotlin.rickmorty.data.DataRepository
import com.ynov.kotlin.rickmorty.data.entity.mapper.CharacterRemoteEntityDataMapper
import com.ynov.kotlin.rickmorty.data.entity.mapper.LocationRemoteEntityDataMapper
import com.ynov.kotlin.rickmorty.data.entity.mapper.OriginRemoteEntityDataMapper
import com.ynov.kotlin.rickmorty.data.manager.ApiManagerImpl
import com.ynov.kotlin.rickmorty.data.manager.CacheManagerImpl
import com.ynov.kotlin.rickmorty.presentation.characterdetail.viewmodel.CharacterDetailViewModel
import com.ynov.kotlin.rickmorty.presentation.characterlist.adapter.CharacterListAdapter
import com.ynov.kotlin.rickmorty.presentation.characterlist.viewmodel.CharacterListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val myModule = module {
    single { DataRepository(get(), get(), get()) }
    single { CharacterRemoteEntityDataMapper(get(), get()) }
    single { OriginRemoteEntityDataMapper() }
    single { LocationRemoteEntityDataMapper() }
    single { ApiManagerImpl() }
    single { CacheManagerImpl() }
    viewModel { CharacterListViewModel(get()) }
    viewModel { CharacterDetailViewModel(get()) }
    factory { CharacterListAdapter(get()) }


}
