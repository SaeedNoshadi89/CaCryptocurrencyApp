package com.sn.cacryptocurrencyapp.domain.use_cases.get_coin

import com.sn.cacryptocurrencyapp.common.Resource
import com.sn.cacryptocurrencyapp.data.remote.dto.toCoin
import com.sn.cacryptocurrencyapp.data.remote.dto.toCoinDetail
import com.sn.cacryptocurrencyapp.domain.model.Coin
import com.sn.cacryptocurrencyapp.domain.model.CoinDetail
import com.sn.cacryptocurrencyapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {

    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading())
            val coin = repository.getCoinsBId(coinId).toCoinDetail()
            emit(Resource.Success(coin))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server'. check your internet connection"))
        }
    }
}