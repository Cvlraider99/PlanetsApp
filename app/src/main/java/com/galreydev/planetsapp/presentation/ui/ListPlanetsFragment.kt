package com.galreydev.planetsapp.presentation.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.galreydev.planetsapp.databinding.FragmentListPlanetsBinding
import com.galreydev.planetsapp.presentation.ui.adapter.PlanetAdapter
import com.galreydev.planetsapp.presentation.viewmodel.PlanetsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListPlanetsFragment : Fragment() {

    private val binding: FragmentListPlanetsBinding by lazy {
        FragmentListPlanetsBinding.inflate(LayoutInflater.from(context),null,false)
    }

    private val planetViewModel: PlanetsViewModel by viewModels()
    private val planetAdapter = PlanetAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("Planetas","Si se esta creando la lista")
        planetViewModel.planets.observe(viewLifecycleOwner){ index ->
            Log.d("Planetas","Me da de respuesta $index")
            binding.rvPlanets.apply {
                layoutManager = LinearLayoutManager(context)
                adapter = planetAdapter

                planetAdapter.submitList(index.results)

            }
        }
    }


}