package com.globant.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.globant.data.entity.MovieEntity

@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(entities: List<MovieEntity>)

    @Query("SELECT * FROM MovieEntity where type=:type")
    suspend fun getAllByType(type: String): List<MovieEntity>
}
