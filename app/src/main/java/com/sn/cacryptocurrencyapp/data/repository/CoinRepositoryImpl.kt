package com.sn.cacryptocurrencyapp.data.repository

import com.sn.cacryptocurrencyapp.data.remote.CoinPaprikaApi
import com.sn.cacryptocurrencyapp.data.remote.dto.CoinDetailDto
import com.sn.cacryptocurrencyapp.data.remote.dto.CoinDto
import com.sn.cacryptocurrencyapp.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
): CoinRepository {
    override suspend fun getCoins(): List<CoinDto> =
        api.getCoins()

    override suspend fun getCoinsBId(coinId: String): CoinDetailDto =
        api.getCoinById(conId = coinId)
}