package com.globant.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.globant.data.entity.AccountEntity

@Dao
interface AccountDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(entity: AccountEntity)

    @Query("SELECT * FROM AccountEntity")
    suspend fun get(): AccountEntity
}
