package com.example.mini_application.data.repository

import com.example.mini_application.data.api.ApiService
import com.example.mini_application.data.model.CoinModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class CoinRepository @Inject constructor(private val apiService: ApiService) {

    suspend fun getAllCoins(): Response<CoinModel> = withContext(Dispatchers.IO) {
        return@withContext apiService.getAllCity()
    }
}
