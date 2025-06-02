package com.galreydev.planetsapp.data.network

import com.galreydev.planetsapp.data.model.Index
import retrofit2.http.GET

interface GetPlanetsInterface {
    @GET("/planets")
    suspend fun getPlanets(): Index
}