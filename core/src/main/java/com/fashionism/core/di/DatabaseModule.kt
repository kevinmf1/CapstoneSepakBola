package com.fashionism.core.di

import android.content.Context
import androidx.room.Room
import com.fashionism.core.data.source.local.room.PlayerDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import net.sqlcipher.database.SQLiteDatabase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): PlayerDatabase {
        val passphrase: ByteArray = SQLiteDatabase.getBytes("dicoding".toCharArray())
        val factory = net.sqlcipher.database.SupportFactory(passphrase)
        return Room.databaseBuilder(
            context,
            PlayerDatabase::class.java, "Player.db"
        ).fallbackToDestructiveMigration().openHelperFactory(factory).build()
    }

    @Provides
    fun provideTourismDao(database: PlayerDatabase) = database.playerDao()
}