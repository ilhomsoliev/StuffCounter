package com.ilhomsoliev.local.domain.use_cases

import com.ilhomsoliev.local.domain.model.Stuff
import com.ilhomsoliev.local.domain.repository.StuffRepository
import javax.inject.Inject

class AddStuffUseCase @Inject constructor(
    private val repository: StuffRepository
) {
    suspend operator fun invoke(
        id: Int? = null,
        name: String,
        count: Int,
        color: Long,
        defaultValue: Int,
        resetValue: Int,
        increaseBy: Int,
        decreaseBy: Int
    ) {
        val stuff = Stuff(
            id = id,
            name = name,
            count = count,
            color = color,
            defaultValue = defaultValue,
            resetValue = resetValue,
            increaseBy = increaseBy,
            decreaseBy = decreaseBy,
        )
        val response = repository.insertStuff(stuff)
    }
}