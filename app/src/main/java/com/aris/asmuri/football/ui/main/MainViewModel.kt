package com.aris.asmuri.football.ui.main

import android.app.Application
import androidx.lifecycle.*
import com.aris.asmuri.football.data.repository.LeagueRepository
import com.aris.asmuri.football.model.LeagueModel

class MainViewModel(application: Application): AndroidViewModel(application){

    private var _listLeague = MutableLiveData<List<LeagueModel>>()

    val state = LeagueRepository.getLeagueState()

    init {
        refreshListLeague()
    }

    fun refreshListLeague() {
        _listLeague.postValue(emptyList())
        _listLeague = LeagueRepository.getLeagueListFromApi()
    }

    fun getListLeague(): LiveData<List<LeagueModel>>? = _listLeague

    class Factory(val app: Application) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return MainViewModel(app) as T
            }
            throw IllegalArgumentException("Cannot create ViewModel")
        }

    }

}