package com.fashionism.core.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Player(
    var idPlayer: Int,
    var name: String,
    var club: String,
    var rate: String,
    var position: String,
    var allGoalsUntilNow: Int,
    var allAssistsUntilNow: Int,
    var activePlayer: String,
    var description: String,
    var photo: String,
    var isFavorite: Boolean = false
) : Parcelable
