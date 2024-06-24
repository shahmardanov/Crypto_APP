package com.example.mini_application.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lazaapp.ui.home.HomeViewModel
import com.example.mini_application.R
import com.example.mini_application.base.BaseFragment
import com.example.mini_application.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment :  BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeData()

    }

    private fun observeData() {
        viewModel.brandData.observe(viewLifecycleOwner) {
            brandAdapter.updateList(it)
        }

        viewModel.data.observe(viewLifecycleOwner) {
            newArrivalAdapter.updateList(it)
        }

        viewModel.loading.observe(viewLifecycleOwner) {

        }

        viewModel.error.observe(viewLifecycleOwner) {

        }
    }


}