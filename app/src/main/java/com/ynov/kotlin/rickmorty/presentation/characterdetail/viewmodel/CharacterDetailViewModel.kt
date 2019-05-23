package com.ynov.kotlin.rickmorty.presentation.characterdetail.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ynov.kotlin.rickmorty.data.DataRepository
import com.ynov.kotlin.rickmorty.presentation.characterlist.viewdatawrapper.CharacterViewDataWrapper
import io.reactivex.android.schedulers.AndroidSchedulers.mainThread
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

class CharacterDetailViewModel(private val dataRepository: DataRepository) : ViewModel() {

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()
    val character: MutableLiveData<CharacterViewDataWrapper> = MutableLiveData()


    override fun onCleared() {
        compositeDisposable.clear()
    }
    fun retrieveCharacter(id: Int) {
        compositeDisposable.add(dataRepository.retrieveOneCharacter(id)
            .subscribeOn(Schedulers.io())
            .observeOn(mainThread())
            .subscribeBy(
                onSuccess = {
                    character.postValue(
                        CharacterViewDataWrapper(
                            it
                        )
                    )
                },
                onError = {
                    throw it
                }
            ))
    }
}
