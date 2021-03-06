package com.aris.asmuri.football.utils

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.aris.asmuri.football.data.db.entity.MatchFavoriteEntity
import com.aris.asmuri.football.data.db.entity.TeamFavoriteEntity
import com.aris.asmuri.football.model.MatchFavoriteModel
import com.aris.asmuri.football.model.MatchModel
import com.aris.asmuri.football.model.TeamFavoriteModel
import com.aris.asmuri.football.model.TeamModel
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

object Helper {

    fun clearImageView(context: Context, imageView: ImageView){
        Glide.with(context).clear(imageView)
    }

    fun setImageToView(context: Context, imagePath: String, imageView: ImageView){
        Glide.with(context).load(imagePath).into(imageView)
    }

    fun parseDateTimeFormat(date: String?, time: String?): String? = if (!date.isNullOrEmpty()) {
        if (time.isNullOrEmpty()) {
            val dateResult: Date? = dateFormatter("yyyy-MM-dd").parse(date)
            val dateFormat = SimpleDateFormat("dd MMMM yyy", Locale.getDefault())
            dateFormat.format(dateResult!!)
        } else {
            val dateResult: Date? = dateFormatter("yyyy-MM-dd hh:mm").parse("$date $time")
            val dateTimeFormat = SimpleDateFormat("dd MMMM yyyy hh:mm aa", Locale.getDefault())
            dateTimeFormat.timeZone = TimeZone.getTimeZone("GMT+7")
            dateTimeFormat.format(dateResult!!)
        }
    } else {
        "-"
    }

    private fun dateFormatter(format: String): DateFormat = SimpleDateFormat(format, Locale.getDefault())

    fun replaceStringForFootballData(string: String?): String? = string?.replace(";", "\n")

    fun replaceStringForPlayerData(string: String?): String? = string?.replace("; ", "\n")

    fun convertMatchFavoriteModelToMatchFavoriteEntity(data: MatchFavoriteModel): MatchFavoriteEntity {
        return MatchFavoriteEntity(
            id = data.id,
            idEvent = data.idEvent,
            strSport = data.strSport,
            idLeague = data.idLeague,
            strLeague = data.strLeague,
            strSeason = data.strSeason,
            strHomeTeam = data.strHomeTeam,
            strAwayTeam = data.strAwayTeam,
            intHomeScore = data.intHomeScore,
            intAwayScore = data.intAwayScore,
            intRound = data.intRound,
            strHomeGoalDetails = data.strHomeGoalDetails,
            strHomeRedCards = data.strHomeRedCards,
            strHomeYellowCards = data.strHomeYellowCards,
            strHomeLineupGoalkeeper = data.strHomeLineupGoalkeeper,
            strHomeLineupDefense = data.strHomeLineupDefense,
            strHomeLineupMidfield = data.strHomeLineupMidfield,
            strHomeLineupForward = data.strHomeLineupForward,
            strHomeFormation = data.strHomeFormation,
            strAwayGoalDetails = data.strAwayGoalDetails,
            strAwayRedCards = data.strAwayRedCards,
            strAwayYellowCards = data.strAwayYellowCards,
            strAwayLineupGoalkeeper = data.strAwayLineupGoalkeeper,
            strAwayLineupDefense = data.strAwayLineupDefense,
            strAwayLineupMidfield = data.strAwayLineupMidfield,
            strAwayLineupForward = data.strAwayLineupForward,
            strAwayFormation = data.strAwayFormation,
            intHomeShots = data.intHomeShots,
            intAwayShots = data.intAwayShots,
            dateEvent = data.dateEvent,
            strTime = data.strTime,
            strDate = data.strDate,
            idHomeTeam = data.idHomeTeam,
            idAwayTeam = data.idAwayTeam,
            strPostponed = data.strPostponed,
            strBadgeHomeTeam = data.strBadgeHomeTeam,
            strBadgeAwayTeam = data.strBadgeAwayTeam
        )
    }

    fun convertMatchModelToMatchFavoriteModel(data: MatchModel): MatchFavoriteModel {
        return MatchFavoriteModel(
            id = null,
            idEvent = data.idEvent,
            strSport = data.strSport,
            idLeague = data.idLeague,
            strLeague = data.strLeague,
            strSeason = data.strSeason,
            strHomeTeam = data.strHomeTeam,
            strAwayTeam = data.strAwayTeam,
            intHomeScore = data.intHomeScore,
            intAwayScore = data.intAwayScore,
            intRound = data.intRound,
            strHomeGoalDetails = data.strHomeGoalDetails,
            strHomeRedCards = data.strHomeRedCards,
            strHomeYellowCards = data.strHomeYellowCards,
            strHomeLineupGoalkeeper = data.strHomeLineupGoalkeeper,
            strHomeLineupDefense = data.strHomeLineupDefense,
            strHomeLineupMidfield = data.strHomeLineupMidfield,
            strHomeLineupForward = data.strHomeLineupForward,
            strHomeFormation = data.strHomeFormation,
            strAwayGoalDetails = data.strAwayGoalDetails,
            strAwayRedCards = data.strAwayRedCards,
            strAwayYellowCards = data.strAwayYellowCards,
            strAwayLineupGoalkeeper = data.strAwayLineupGoalkeeper,
            strAwayLineupDefense = data.strAwayLineupDefense,
            strAwayLineupMidfield = data.strAwayLineupMidfield,
            strAwayLineupForward = data.strAwayLineupForward,
            strAwayFormation = data.strAwayFormation,
            intHomeShots = data.intHomeShots,
            intAwayShots = data.intAwayShots,
            dateEvent = data.dateEvent,
            strTime = data.strTime,
            strDate = data.strDate,
            idHomeTeam = data.idHomeTeam,
            idAwayTeam = data.idAwayTeam,
            strPostponed = data.strPostponed,
            strBadgeHomeTeam = data.strBadgeHomeTeam,
            strBadgeAwayTeam = data.strBadgeAwayTeam
        )
    }

    fun convertFavoriteMatchModelToMatchModel(data: MatchFavoriteModel): MatchModel {
        return MatchModel(
            idEvent = data.idEvent,
            strSport = data.strSport,
            idLeague = data.idLeague,
            strLeague = data.strLeague,
            strSeason = data.strSeason,
            strHomeTeam = data.strHomeTeam,
            strAwayTeam = data.strAwayTeam,
            intHomeScore = data.intHomeScore,
            intAwayScore = data.intAwayScore,
            intRound = data.intRound,
            strHomeGoalDetails = data.strHomeGoalDetails,
            strHomeRedCards = data.strHomeRedCards,
            strHomeYellowCards = data.strHomeYellowCards,
            strHomeLineupGoalkeeper = data.strHomeLineupGoalkeeper,
            strHomeLineupDefense = data.strHomeLineupDefense,
            strHomeLineupMidfield = data.strHomeLineupMidfield,
            strHomeLineupForward = data.strHomeLineupForward,
            strHomeFormation = data.strHomeFormation,
            strAwayGoalDetails = data.strAwayGoalDetails,
            strAwayRedCards = data.strAwayRedCards,
            strAwayYellowCards = data.strAwayYellowCards,
            strAwayLineupGoalkeeper = data.strAwayLineupGoalkeeper,
            strAwayLineupDefense = data.strAwayLineupDefense,
            strAwayLineupMidfield = data.strAwayLineupMidfield,
            strAwayLineupForward = data.strAwayLineupForward,
            strAwayFormation = data.strAwayFormation,
            intHomeShots = data.intHomeShots,
            intAwayShots = data.intAwayShots,
            dateEvent = data.dateEvent,
            strTime = data.strTime,
            strDate = data.strDate,
            idHomeTeam = data.idHomeTeam,
            idAwayTeam = data.idAwayTeam,
            strPostponed = data.strPostponed,
            strBadgeHomeTeam = data.strBadgeHomeTeam,
            strBadgeAwayTeam = data.strBadgeAwayTeam
        )
    }

    fun convertTeamFavoriteModelToTeamFavoriteEntity(data: TeamFavoriteModel): TeamFavoriteEntity {
        return TeamFavoriteEntity(
            id = data.id,
            idTeam = data.idTeam,
            strTeam = data.strTeam,
            strStadium = data.strStadium,
            strDescriptionEN = data.strDescriptionEN,
            strTeamBadge = data.strTeamBadge,
            strSport = data.strSport
        )
    }

    fun convertTeamModelToTeamFavoriteModel(data: TeamModel): TeamFavoriteModel {
        return TeamFavoriteModel(
            id = null,
            idTeam = data.idTeam,
            strTeam = data.strTeam,
            strStadium = data.strStadium,
            strDescriptionEN = data.strDescriptionEN,
            strTeamBadge = data.strTeamBadge,
            strSport = data.strSport
        )
    }

    fun convertTeamFavoriteModelToTeamModel(data: TeamFavoriteModel): TeamModel {
        return TeamModel(
            idTeam = data.idTeam,
            strTeam = data.strTeam,
            strStadium = data.strStadium,
            strDescriptionEN = data.strDescriptionEN,
            strTeamBadge = data.strTeamBadge,
            strSport = data.strSport
        )
    }

}