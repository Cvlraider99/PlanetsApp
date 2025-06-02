package com.galreydev.planetsapp.di

import com.galreydev.planetsapp.domain.repository.UserRepository
import com.galreydev.planetsapp.domain.usecase.GetUserUseCase
import com.galreydev.planetsapp.domain.usecase.InsertUserUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object UseCaseModule {

    @Provides
    fun provideGetUsersUseCase(repository: UserRepository): GetUserUseCase =
        GetUserUseCase(repository)

    @Provides
    fun provideInsertUserUseCase(repository: UserRepository): InsertUserUseCase =
        InsertUserUseCase(repository)

}