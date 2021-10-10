package com.example.mvvmexploration.explore.usecase

import com.example.mvvmexploration.common.CarouselItem
import com.example.mvvmexploration.common.CarouselsRepository
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

class HelpFriendsUseCase @Inject constructor(
    private val repo: CarouselsRepository
) {
    operator fun invoke() = repo.mainCarousel()
        .map<List<CarouselItem>, Result> { items ->
            Result.UiUpdate(items.map {
                UiCarouselItem(
                    name = it.name,
                    title = it.title
                )
            })
        }
        .catch { emit(Result.Error) }
        .onStart { emit(Result.Loading) }
}
