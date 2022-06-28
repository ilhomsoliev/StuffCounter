package com.ilhomsoliev.local.domain.repository

import com.ilhomsoliev.local.domain.model.Stuff
import kotlinx.coroutines.flow.Flow

interface StuffRepository {

    fun getStuffs(): Flow<List<Stuff>>

    suspend fun getStuffById(id: Int): Stuff?

    suspend fun insertStuff(stuff: Stuff)

    suspend fun deleteStuff(stuff: Stuff)

}