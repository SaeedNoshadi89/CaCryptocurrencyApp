package com.sn.cacryptocurrencyapp.presentation.coin_detail

import com.sn.cacryptocurrencyapp.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)