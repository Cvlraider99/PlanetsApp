package com.galreydev.planetsapp.data.network

import com.galreydev.planetsapp.data.model.DetallePlaneta
import retrofit2.http.GET
import retrofit2.http.Path

interface GetDetalleInterface {
    @GET("/planets/{id}")
    suspend fun getDetallePlanet(
        @Path("id") id: Int
    ): DetallePlaneta

}