package com.galreydev.planetsapp.data.repository

import com.galreydev.planetsapp.data.model.Index
import com.galreydev.planetsapp.data.network.GetPlanetsInterface
import javax.inject.Inject

class PlanetsRepository @Inject constructor(private val apiService: GetPlanetsInterface) {
    suspend fun getPlanets(): Index{
        return apiService.getPlanets()
    }
}