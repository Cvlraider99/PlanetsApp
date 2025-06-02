package com.galreydev.planetsapp.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.galreydev.planetsapp.data.model.Index
import com.galreydev.planetsapp.data.repository.PlanetsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PlanetsViewModel @Inject constructor(private val repository: PlanetsRepository) : ViewModel() {

    private val _planets = MutableLiveData<Index>()
    val planets: LiveData<Index> get() = _planets

    init {
        loadPlanets()
    }

    private fun loadPlanets(){
        viewModelScope.launch {
            try{
                _planets.value = repository.getPlanets()
            }catch (e: Exception){
                Log.e("PlanetsViewModel", "Error loading planets", e)
            }
        }
    }
}