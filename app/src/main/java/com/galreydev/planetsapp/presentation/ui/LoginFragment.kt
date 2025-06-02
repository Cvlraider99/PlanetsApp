package com.galreydev.planetsapp.presentation.ui

import android.app.DatePickerDialog
import android.icu.util.Calendar
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.navigation.fragment.findNavController
import com.galreydev.planetsapp.databinding.FragmentLoginBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {

    private val binding: FragmentLoginBinding by lazy {
        FragmentLoginBinding.inflate(LayoutInflater.from(context), null, false)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {

            /**Configuracion del calendario y spinner**/
            configureSpinner()
            etFechaNacimiento.setOnClickListener {
                showDatePicker()
            }



            mbLogin.setOnClickListener {
                findNavController().navigate(
                    LoginFragmentDirections.actionLoginFragmentToListPlanetsFragment()
                )
            }
        }
    }

    private fun showDatePicker (){
        val calendar = Calendar.getInstance()
        val datePicker = DatePickerDialog(
            requireContext(),
            { _, year, month, day ->
                val dateStr = "%02d/%02d/%04d".format(day, month + 1, year)
                binding.etFechaNacimiento.setText(dateStr)
            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        )

        datePicker.show()
    }

    private fun configureSpinner(){
        val countries = listOf("México", "Argentina", "Chile", "Colombia")
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, countries)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spnPais.adapter = adapter
    }
}