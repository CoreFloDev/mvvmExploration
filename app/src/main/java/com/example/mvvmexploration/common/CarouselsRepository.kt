package com.example.mvvmexploration.common

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

interface CarouselsRepository {

    fun mainCarousel(): Flow<List<CarouselItem>>
}

data class CarouselItem(val name: String, val title: String)

// Retrofit or whatever the provider you currently use
class RetrofitCarouselsRepository @Inject constructor() : CarouselsRepository {
    override fun mainCarousel(): Flow<List<CarouselItem>> = flowOf(
        listOf(
            CarouselItem("Maya", "Sr. Business Manager"),
            CarouselItem("Maya", "Sr. Business Manager"),
            CarouselItem("Maya", "Sr. Business Manager"),
            CarouselItem("Gabriela", "Flutter Developer")
        )
    )

}
