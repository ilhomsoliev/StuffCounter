package com.ilhomsoliev.local.data.local

import androidx.room.*
import com.ilhomsoliev.local.domain.model.Stuff
import kotlinx.coroutines.flow.Flow

@Dao
interface StuffDao {
    @Query("SELECT * FROM stuff")
    fun getStuffs(): Flow<List<Stuff>>

    @Query("SELECT * FROM stuff WHERE id = :id")
    suspend fun getStuffById(id: Int): Stuff?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStuff(stuff: Stuff)

    @Delete
    suspend fun deleteStuff(stuff: Stuff)
}