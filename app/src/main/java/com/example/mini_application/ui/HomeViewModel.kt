package com.example.lazaapp.ui.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mini_application.data.model.CoinModel
import com.example.mini_application.data.model.Data
import com.example.mini_application.data.repository.CoinRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: CoinRepository) : ViewModel() {

    val data = MutableLiveData<List<Data>>()
    val loading = MutableLiveData<Boolean>()
    val error = MutableLiveData<String>()

    init {
        getInitData()
    }

    private fun getInitData() {
        getProducts()
    }



    private fun getProducts() {
        loading.value = true
        viewModelScope.launch {
            try {
                val response = repository.getAllCoins()

                if (response.isSuccessful) {

                    response.body()?.let {
                        data.value = it.data!!
                    }
                } else {
                    error.value = response.errorBody().toString()
                }
            }catch (e:Exception){
                error.value=e.localizedMessage.toString()
            }

        }
    }
}