package com.fashionism.core.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "player")
@Suppress("unused", "unused")
data class PlayerEntity(
    @PrimaryKey
    @ColumnInfo(name = "idPlayer")
    var idPlayer: Int,

    @ColumnInfo(name = "name")
    var name: String,

    @ColumnInfo(name = "clubPlayer")
    var club: String,

    @ColumnInfo(name = "rate")
    var rate: String,

    @ColumnInfo(name = "position")
    var position: String,

    @ColumnInfo(name = "allGoalsUntilNow")
    var allGoalsUntilNow: Int,

    @ColumnInfo(name = "allAssistsUntilNow")
    var allAssistsUntilNow: Int,

    @ColumnInfo(name = "activePlayer")
    var activePlayer: String,

    @ColumnInfo(name = "description")
    var description: String,

    @ColumnInfo(name = "photo")
    var photo: String,

    @ColumnInfo(name = "isFavorite")
    var isFavorite: Boolean = false
)
