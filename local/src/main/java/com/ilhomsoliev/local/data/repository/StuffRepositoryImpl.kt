package com.ilhomsoliev.local.data.repository

import com.ilhomsoliev.local.data.local.StuffDao
import com.ilhomsoliev.local.domain.model.Stuff
import com.ilhomsoliev.local.domain.repository.StuffRepository
import kotlinx.coroutines.flow.Flow

class StuffRepositoryImpl(
    private val dao: StuffDao
) : StuffRepository {
    override fun getStuffs(): Flow<List<Stuff>> = dao.getStuffs()

    override suspend fun getStuffById(id: Int): Stuff? = dao.getStuffById(id)

    override suspend fun insertStuff(stuff: Stuff) = dao.insertStuff(stuff)

    override suspend fun deleteStuff(stuff: Stuff) = dao.deleteStuff(stuff)
}