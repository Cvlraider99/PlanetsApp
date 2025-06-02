package com.galreydev.planetsapp.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.galreydev.planetsapp.data.local.dao.UserDao
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val userDao: UserDao
) : ViewModel() {

    private val _userExist = MutableLiveData<Boolean>()
    val userExist: LiveData<Boolean> = _userExist

    init {
        viewModelScope.launch {
            val users = userDao.getAll().firstOrNull() ?: emptyList()
            _userExist.postValue(users.isNotEmpty())
        }
    }
}