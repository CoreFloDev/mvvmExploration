package com.example.mvvmexploration.notifications

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NotificationsViewModel : ViewModel() {

    private val _text = MutableLiveData("This is notifications Fragment")
    val text: LiveData<String> = _text
}
