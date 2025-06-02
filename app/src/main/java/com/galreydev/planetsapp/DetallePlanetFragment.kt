package com.galreydev.planetsapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.galreydev.planetsapp.databinding.FragmentDetallePlanetBinding

class DetallePlanetFragment : Fragment() {

    private val binding: FragmentDetallePlanetBinding by lazy {
        FragmentDetallePlanetBinding.inflate(LayoutInflater.from(context), null, false)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}