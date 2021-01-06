package com.aris.asmuri.football.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.aris.asmuri.football.data.db.dao.MatchFavoriteDatabase
import com.aris.asmuri.football.data.db.entity.convertToMatchFavoriteModel
import com.aris.asmuri.football.model.MatchFavoriteModel
import com.aris.asmuri.football.model.MatchModel
import com.aris.asmuri.football.utils.Helper.convertMatchFavoriteModelToMatchFavoriteEntity
import com.aris.asmuri.football.utils.Helper.convertMatchModelToMatchFavoriteModel

class MatchFavoriteRepository(private val database: MatchFavoriteDatabase) {

    companion object {
        private val TAG = MatchFavoriteRepository::class.java.simpleName
    }

    val favoriteMatchList: LiveData<List<MatchFavoriteModel>>? =
        Transformations.map(database.favoriteMatchDao.getMatchFavoriteList()) {
            it.convertToMatchFavoriteModel()
        }

    fun validateMatch(idEvent: Int): Int {
        return database.favoriteMatchDao.validateMatchFavorite(idEvent)
    }

    fun removeMatchFavorite(idEvent: Int) {
        database.favoriteMatchDao.deleteMatchFavorite(idEvent)
        Log.d(TAG, "Successfully removed match with id : $idEvent from favorite")
    }

    fun addToFavoriteMatch(match: MatchModel) {
        val favoriteMatch = convertMatchModelToMatchFavoriteModel(match)
        val data = convertMatchFavoriteModelToMatchFavoriteEntity(favoriteMatch)

        database.favoriteMatchDao.insertMatchFavorite(data)

        Log.d(TAG, "Successfully added match ${data.idEvent} to favorite")
    }

}