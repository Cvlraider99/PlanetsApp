package com.galreydev.planetsapp.data.model

data class Index(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<Result>
)