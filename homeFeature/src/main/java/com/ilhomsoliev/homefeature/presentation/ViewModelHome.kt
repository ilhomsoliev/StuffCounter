package com.ilhomsoliev.homefeature.presentation

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ilhomsoliev.local.domain.use_cases.AddStuffUseCase
import com.ilhomsoliev.local.domain.use_cases.GetStuffsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViewModelHome @Inject constructor(
    private val getStuffsUseCase: GetStuffsUseCase,
    private val addStuffsUseCase: AddStuffUseCase
) : ViewModel() {

    private val _stateStuffs = mutableStateOf(StuffsState())
    val stateStuffs: State<StuffsState> = _stateStuffs

    init {
        getStuffs()
    }

    private fun getStuffs() {
        Log.d("Hello", "ViewMOdelHome")
        getStuffsUseCase().onEach { stuffs ->
            _stateStuffs.value = StuffsState(response = stuffs)
        }.launchIn(viewModelScope)
    }
    fun addStuff(
        id:Int,
        name: String,
        count: Int,
        color: Long,
        defaultValue: Int,
        resetValue: Int,
        increaseBy: Int,
        decreaseBy: Int
    ) {
        viewModelScope.launch {
            addStuffsUseCase(
                id = id,
                name = name,
                count = count,
                color = color,
                defaultValue = defaultValue,
                resetValue = resetValue,
                increaseBy = increaseBy,
                decreaseBy = decreaseBy,
            )
        }
    }
}