package com.ynov.kotlin.rickmorty.presentation.characterdetail.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ynov.kotlin.rickmorty.data.DataRepository
import com.ynov.kotlin.rickmorty.data.model.Character
import com.ynov.kotlin.rickmorty.presentation.viewdatawrapper.CharacterViewDataWrapper
import io.reactivex.android.schedulers.AndroidSchedulers.mainThread
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

class CharacterDetailViewModel(private val dataRepository: DataRepository) : ViewModel() {
    val character: MutableLiveData<CharacterViewDataWrapper> = MutableLiveData()


    fun retrieveCharacter(id: Int) {
        dataRepository.retrieveOneCharacter(id)
            .subscribeOn(Schedulers.io())
            .observeOn(mainThread())
            .subscribeBy(
                onSuccess = {
                    character.postValue(CharacterViewDataWrapper(it))
                },
                onError = {
                    throw it
                }
            )
    }
}
