package com.example.mini_application.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import com.example.lazaapp.ui.home.HomeViewModel
import com.example.mini_application.R
import com.example.mini_application.base.BaseFragment
import com.example.mini_application.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {
    private val viewModel by viewModels<HomeViewModel>()
    private val coinAdapter = CoinAdapter()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvHome.adapter = coinAdapter
        observeData()

    }

    private fun observeData() {
        viewModel.data.observe(viewLifecycleOwner) {
            Log.e("gelendata55", it.toString())
            coinAdapter.updateList(it)
        }


        viewModel.loading.observe(viewLifecycleOwner) {
            Log.e("gelendata", it.toString())

        }

        viewModel.error.observe(viewLifecycleOwner) {
            Log.e("gelendata", it.toString())

        }
    }


}