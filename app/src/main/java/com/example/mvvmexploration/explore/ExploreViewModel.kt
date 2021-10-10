package com.example.mvvmexploration.explore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmexploration.explore.usecase.HelpFriendsUseCase
import com.example.mvvmexploration.explore.usecase.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ExploreViewModel @Inject constructor(
    helpFriendsUseCase: HelpFriendsUseCase
) : ViewModel() {

    private val _result = MutableLiveData<Result>()
    val result: LiveData<Result> = _result

    init {
        helpFriendsUseCase()
            .onEach { _result.value = it }
            .launchIn(viewModelScope)
    }

}
