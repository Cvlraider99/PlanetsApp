package com.galreydev.planetsapp.domain.usecase

import com.galreydev.planetsapp.domain.model.User
import com.galreydev.planetsapp.domain.repository.UserRepository
import javax.inject.Inject

class InsertUserUseCase @Inject constructor( private val repository: UserRepository) {
    suspend operator fun invoke(user: User) = repository.insertUser(user)
}