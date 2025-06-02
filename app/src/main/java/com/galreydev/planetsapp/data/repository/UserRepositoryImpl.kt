package com.galreydev.planetsapp.data.repository

import com.galreydev.planetsapp.data.local.dao.UserDao
import com.galreydev.planetsapp.data.local.entity.toDomain
import com.galreydev.planetsapp.data.local.entity.toEntity
import com.galreydev.planetsapp.domain.model.User
import com.galreydev.planetsapp.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(private val dao: UserDao): UserRepository{
    override fun getUsers(): Flow<List<User>> =
        dao.getAll().map { list -> list.map { it.toDomain() } }




    override suspend fun insertUser(user: User) {
        dao.insert(user.toEntity())
    }

}