package com.galreydev.planetsapp.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.galreydev.planetsapp.domain.model.User
import com.galreydev.planetsapp.domain.usecase.GetUserUseCase
import com.galreydev.planetsapp.domain.usecase.InsertUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    getUsersUseCase: GetUserUseCase,
    private val insertUserUseCase: InsertUserUseCase,
) : ViewModel() {

    val users: LiveData<List<User>> = getUsersUseCase().asLiveData()

    fun addUser(user: User) = viewModelScope.launch {
        insertUserUseCase(user)
    }

}