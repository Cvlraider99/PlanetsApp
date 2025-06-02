package com.galreydev.planetsapp.data.repository

import com.galreydev.planetsapp.data.model.DetallePlaneta
import com.galreydev.planetsapp.data.network.GetDetalleInterface
import javax.inject.Inject

class DetallePlanetaRepository @Inject constructor(private val apiService: GetDetalleInterface) {
    suspend fun getDetallePlanet(id: Int): DetallePlaneta {
        return apiService.getDetallePlanet(id)
    }

}