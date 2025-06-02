package com.galreydev.planetsapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.galreydev.planetsapp.data.local.dao.UserDao
import com.galreydev.planetsapp.data.local.entity.UserEntity

@Database(entities = [UserEntity::class], version = 1)
abstract class AppDataBase: RoomDatabase() {
    abstract fun userDao(): UserDao
}