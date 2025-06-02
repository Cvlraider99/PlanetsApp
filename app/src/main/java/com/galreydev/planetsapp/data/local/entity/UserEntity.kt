package com.galreydev.planetsapp.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.galreydev.planetsapp.domain.model.User

@Entity(tableName = "users")
data class UserEntity(
    @PrimaryKey val id: Int,
    val name: String,
    val lastNameP: String,
    val lastNameM: String,
    val birthDate: String,
    val country: String
)


fun UserEntity.toDomain(): User = User(name,lastNameP,lastNameM,birthDate,country)
fun User.toEntity(): UserEntity = UserEntity(0, name,lastNameP,lastNameM,birthDate,country)
