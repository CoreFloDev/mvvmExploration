package com.example.mvvmexploration.explore.usecase

sealed class Result {
    object Loading : Result()
    object Error : Result()
    data class UiUpdate(val list: List<UiCarouselItem>) : Result()
}

data class UiCarouselItem(
    val name: String, val title: String
)
