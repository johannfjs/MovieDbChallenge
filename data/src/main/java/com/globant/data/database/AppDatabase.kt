package com.globant.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.globant.data.dao.AccountDao
import com.globant.data.dao.MovieDao
import com.globant.data.entity.AccountEntity
import com.globant.data.entity.MovieEntity

@Database(
    entities = [AccountEntity::class, MovieEntity::class],
    version = 1,
    exportSchema = false,
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun accountDao(): AccountDao

    abstract fun movieDao(): MovieDao
}
