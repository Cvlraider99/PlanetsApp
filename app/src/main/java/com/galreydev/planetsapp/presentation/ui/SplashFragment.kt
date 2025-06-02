package com.galreydev.planetsapp.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.galreydev.planetsapp.databinding.FragmentSplashBinding
import com.galreydev.planetsapp.presentation.viewmodel.SplashViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashFragment : Fragment() {


    private val binding: FragmentSplashBinding by lazy {
        FragmentSplashBinding.inflate(LayoutInflater.from(context), null, false)
    }

    private val viewModel: SplashViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.userExist.observe(viewLifecycleOwner){
            if(it){
                findNavController().navigate(
                    SplashFragmentDirections.actionSplashFragmentToListPlanetsFragment()
                )
            }else{
                findNavController().navigate(
                    SplashFragmentDirections.actionSplashFragmentToLoginFragment()
                )
            }
        }
    }


}