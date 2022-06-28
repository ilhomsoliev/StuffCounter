package com.ilhomsoliev.addstufffeature.presentation

import com.ilhomsoliev.local.domain.model.Stuff

class AddStuffState(
    var isLoading: Boolean = false,
    var response: Boolean? = null,
    val error: String = ""
)