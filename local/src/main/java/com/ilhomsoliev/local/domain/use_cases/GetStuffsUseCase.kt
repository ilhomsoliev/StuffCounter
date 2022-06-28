package com.ilhomsoliev.local.domain.use_cases

import android.util.Log
import com.ilhomsoliev.core.Resource
import com.ilhomsoliev.local.domain.model.Stuff
import com.ilhomsoliev.local.domain.repository.StuffRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetStuffsUseCase @Inject constructor(private val repository: StuffRepository) {

    operator fun invoke(): Flow<List<Stuff>> =
        repository.getStuffs().map {
            it
        }
}