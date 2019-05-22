package com.ynov.kotlin.rickmorty.presentation.view.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ynov.kotlin.rickmorty.data.DataRepository
import com.ynov.kotlin.rickmorty.data.model.Character
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.android.schedulers.AndroidSchedulers.*
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import java.lang.Exception


class HomeViewModel(private val dataRepository: DataRepository) : ViewModel() {

    val character: MutableLiveData<List<Character>> = MutableLiveData()

    init {
        retrieveAllCharacter()
    }

    fun retrieveAllCharacter() {
       dataRepository.retrieveAllCharacterList()
            .subscribeOn(Schedulers.io())
            .observeOn(mainThread())
            .subscribeBy(
                onSuccess = character::postValue,
                onError = {
                    throw it
                }
            )
    }
}