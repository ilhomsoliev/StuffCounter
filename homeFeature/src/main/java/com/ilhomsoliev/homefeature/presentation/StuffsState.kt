package com.ilhomsoliev.homefeature.presentation

import com.ilhomsoliev.local.domain.model.Stuff

class StuffsState(
    var isLoading: Boolean = false,
    var response: List<Stuff>? = null,
    val error: String = ""
)