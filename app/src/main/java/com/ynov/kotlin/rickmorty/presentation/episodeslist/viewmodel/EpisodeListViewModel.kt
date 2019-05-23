package com.ynov.kotlin.rickmorty.presentation.episodeslist.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ynov.kotlin.rickmorty.data.DataRepository
import com.ynov.kotlin.rickmorty.presentation.episodeslist.viewdatawrapper.EpisodeViewDataWrapper
import io.reactivex.android.schedulers.AndroidSchedulers.mainThread
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

class EpisodeListViewModel(private val dataRepository: DataRepository) : ViewModel() {

    val compositeDisposable: CompositeDisposable = CompositeDisposable()
    val episodeList: MutableLiveData<List<EpisodeViewDataWrapper>> = MutableLiveData()

    init {
        retrieveAllEpisodes()
    }

    override fun onCleared() {
        compositeDisposable.clear()
    }

    fun retrieveAllEpisodes() {
        compositeDisposable.add(dataRepository.retrieveAllEpisodes()
            .subscribeOn(Schedulers.io())
            .observeOn(mainThread())
            .subscribeBy(
                onSuccess = { episodeList ->
                    this.episodeList.postValue(episodeList.map {
                        EpisodeViewDataWrapper(
                            it
                        )
                    })
                },
                onError = {
                    throw it
                }
            ))
    }
}