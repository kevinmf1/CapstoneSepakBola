package com.fashionism.core.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.fashionism.core.data.source.local.entity.PlayerEntity


@Database(entities = [PlayerEntity::class], version = 1, exportSchema = false)
abstract class PlayerDatabase : RoomDatabase() {

    abstract fun playerDao(): PlayerDao

}