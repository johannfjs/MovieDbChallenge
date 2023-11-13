package com.globant.data.dao

import androidx.room.Dao
import androidx.room.Insert
import com.globant.data.entity.AccountEntity

@Dao
interface AccountDao {
    @Insert
    suspend fun insert(entity: AccountEntity)
}
