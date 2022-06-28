package com.ilhomsoliev.addstufffeature.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ilhomsoliev.local.domain.use_cases.AddStuffUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViewModelAddStuff @Inject constructor(
    val addStuffsUseCase: AddStuffUseCase
) : ViewModel() {

    private val _stateAddStuff = mutableStateOf(AddStuffState())
    val stateAddStuff: State<AddStuffState> = _stateAddStuff

    fun stop(){
        _stateAddStuff.value = AddStuffState( response = false)
    }
    fun addStuff(
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
                name = name,
                count = count,
                color = color,
                defaultValue = defaultValue,
                resetValue = resetValue,
                increaseBy = increaseBy,
                decreaseBy = decreaseBy,
            )
            _stateAddStuff.value = AddStuffState(response = true)

        }/*.onEach { result: Resource<Int> ->

            when (result) {
                is Resource.Success -> {
                    Log.d("HEllo","Here")
                    _stateAddStuff.value = AddStuffState(response = true)
                }
                is Resource.Error -> {
                    _stateAddStuff.value = AddStuffState(error = result.message ?: "Some error")

                }
                is Resource.Loading -> {
                    _stateAddStuff.value = AddStuffState(isLoading = true)
                }
            }
        }*/
    }
}