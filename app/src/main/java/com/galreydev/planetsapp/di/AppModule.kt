package com.galreydev.planetsapp.di

import com.galreydev.planetsapp.data.network.GetDetalleInterface
import com.galreydev.planetsapp.data.network.GetPlanetsInterface
import com.galreydev.planetsapp.data.network.getUnsafeOkHttpClient
import com.galreydev.planetsapp.data.repository.DetallePlanetaRepository
import com.galreydev.planetsapp.data.repository.PlanetsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://swapi.dev/api/")
            //.client(getUnsafeOkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun providePlanetsApiService(retrofit: Retrofit): GetPlanetsInterface {
        return retrofit.create(GetPlanetsInterface::class.java)
    }

    @Singleton
    @Provides
    fun providePlanetsRepository(apiService: GetPlanetsInterface): PlanetsRepository {
        return PlanetsRepository(apiService)
    }


    //Para el detalle del planeta
    @Singleton
    @Provides
    fun providePlanetDetalleApiService(retrofit: Retrofit): GetDetalleInterface {
        return retrofit.create(GetDetalleInterface::class.java)
    }

    @Singleton
    @Provides
    fun providePlanetDetalleRepository(apiService: GetDetalleInterface): DetallePlanetaRepository {
        return DetallePlanetaRepository(apiService)
    }
}