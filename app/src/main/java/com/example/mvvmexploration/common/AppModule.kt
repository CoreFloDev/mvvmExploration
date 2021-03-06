package com.example.mvvmexploration.common

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    abstract fun provideCarouselsRepository(retrofitCarouselsRepository: RetrofitCarouselsRepository): CarouselsRepository
}
