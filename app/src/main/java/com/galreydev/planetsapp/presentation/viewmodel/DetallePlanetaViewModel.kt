package com.galreydev.planetsapp.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.galreydev.planetsapp.data.model.DetallePlaneta
import com.galreydev.planetsapp.data.repository.DetallePlanetaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetallePlanetaViewModel @Inject constructor(private val repository: DetallePlanetaRepository
,savedStateHandle: SavedStateHandle): ViewModel(){

    private val _detallePlaneta = MutableLiveData<DetallePlaneta>()
    val detallePlaneta: LiveData<DetallePlaneta> get() = _detallePlaneta

    init{
        val url = savedStateHandle.get<String>("urlInfo") ?: ""
        val id = Regex("""/(\d+)/?$""").find(url)?.groupValues?.get(1)?.toIntOrNull()
        loadDetallePlaneta(id ?: 0)
    }

    private fun loadDetallePlaneta(id : Int){
        viewModelScope.launch {
            try {
                _detallePlaneta.value = repository.getDetallePlanet(id)
            }catch (e: Exception){
                Log.e("PlanetsViewModel", "Error loading planets", e)
            }
        }
    }

}