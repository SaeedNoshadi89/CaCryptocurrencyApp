package com.sn.cacryptocurrencyapp.domain.repository

import com.sn.cacryptocurrencyapp.data.remote.dto.CoinDetailDto
import com.sn.cacryptocurrencyapp.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>
    suspend fun getCoinsBId(coinId: String): CoinDetailDto
}