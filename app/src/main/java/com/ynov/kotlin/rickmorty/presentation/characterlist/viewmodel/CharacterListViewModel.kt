package com.ynov.kotlin.rickmorty.presentation.characterlist.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ynov.kotlin.rickmorty.data.DataRepository
import com.ynov.kotlin.rickmorty.presentation.characterlist.viewdatawrapper.CharacterViewDataWrapper
import io.reactivex.android.schedulers.AndroidSchedulers.*
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers


class CharacterListViewModel(private val dataRepository: DataRepository) : ViewModel() {

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()
    val characterList: MutableLiveData<List<CharacterViewDataWrapper>> = MutableLiveData()

    init {
        retrieveAllCharacter()
    }

    override fun onCleared() {
        compositeDisposable.clear()
    }

    fun retrieveAllCharacter() {
        compositeDisposable.add(dataRepository.retrieveAllCharacterList()
            .subscribeOn(Schedulers.io())
            .observeOn(mainThread())
            .subscribeBy(
                onSuccess = { characterList ->
                    this.characterList.postValue(characterList.map {
                        CharacterViewDataWrapper(
                            it
                        )
                    } )
                },
                onError = {
                    throw it
                }
            ))
    }
}