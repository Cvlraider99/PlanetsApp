package com.galreydev.planetsapp.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.galreydev.planetsapp.databinding.FragmentDetallePlanetBinding
import com.galreydev.planetsapp.presentation.viewmodel.DetallePlanetaViewModel

class DetallePlanetFragment : Fragment() {

    private val binding: FragmentDetallePlanetBinding by lazy {
        FragmentDetallePlanetBinding.inflate(LayoutInflater.from(context), null, false)
    }

    private val viewModel: DetallePlanetaViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.detallePlaneta.observe(viewLifecycleOwner){
            with(binding){
                Glide.with(requireContext())
                    .load("https://static.wikia.nocookie.net/dcextendeduniverse/images/3/30/Daily_Planet_-_Logo.png/revision/latest?cb=20201006125356&path-prefix=es")
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .transform(CenterCrop(), RoundedCorners(20))
                    .into(ivPlanet)

                tvPlanet.text = it.name
                tvRotationPeriodValue.text = it.rotation_period
                tvOrbitalValue.text = it.orbital_period
                tvDiametroValue.text = it.diameter
                tvClimateValue.text = it.climate
                tvGravityValue.text = it.gravity
            }
        }
    }
}