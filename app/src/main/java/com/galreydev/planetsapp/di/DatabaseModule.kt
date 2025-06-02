package com.galreydev.planetsapp.di

import android.content.Context
import androidx.room.Room
import com.galreydev.planetsapp.data.local.AppDataBase
import com.galreydev.planetsapp.data.local.dao.UserDao
import com.galreydev.planetsapp.data.repository.UserRepositoryImpl
import com.galreydev.planetsapp.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDataBase =
        Room.databaseBuilder(context, AppDataBase::class.java, "my_database").build()

    @Provides
    fun provideUserDao(db: AppDataBase): UserDao = db.userDao()

    @Provides
    fun provideUserRepository(dao: UserDao): UserRepository = UserRepositoryImpl(dao)
}