package com.ynov.kotlin.rickmorty.presentation.characterlist.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ynov.kotlin.rickmorty.data.DataRepository
import com.ynov.kotlin.rickmorty.data.model.Character
import com.ynov.kotlin.rickmorty.presentation.viewdatawrapper.CharacterViewDataWrapper
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.android.schedulers.AndroidSchedulers.*
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import java.lang.Exception


class CharacterListViewModel(private val dataRepository: DataRepository) : ViewModel() {

    val character: MutableLiveData<List<CharacterViewDataWrapper>> = MutableLiveData()

    init {
        retrieveAllCharacter()
    }

    fun retrieveAllCharacter() {
        dataRepository.retrieveAllCharacterList()
            .subscribeOn(Schedulers.io())
            .observeOn(mainThread())
            .subscribeBy(
                onSuccess = { characterList ->
                    character.postValue(characterList.map { CharacterViewDataWrapper (it) } )
                },
                onError = {
                    throw it
                }
            )
    }
}