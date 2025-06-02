package com.galreydev.planetsapp.domain.usecase

import com.galreydev.planetsapp.domain.model.User
import com.galreydev.planetsapp.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetUserUseCase @Inject constructor( private val repository: UserRepository) {
    operator fun invoke(): Flow<List<User>> = repository.getUsers()
}