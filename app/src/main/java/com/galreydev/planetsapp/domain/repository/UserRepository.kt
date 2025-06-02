package com.galreydev.planetsapp.domain.repository

import com.galreydev.planetsapp.domain.model.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    fun getUsers(): Flow<List<User>>
    suspend fun insertUser(user: User)
}