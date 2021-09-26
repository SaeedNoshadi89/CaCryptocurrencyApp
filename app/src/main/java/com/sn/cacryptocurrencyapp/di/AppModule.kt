package com.sn.cacryptocurrencyapp.di

import com.sn.cacryptocurrencyapp.common.Constants
import com.sn.cacryptocurrencyapp.data.remote.CoinPaprikaApi
import com.sn.cacryptocurrencyapp.data.repository.CoinRepositoryImpl
import com.sn.cacryptocurrencyapp.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providePaprikaApi(): CoinPaprikaApi =
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinPaprikaApi::class.java)


    @Provides
    @Singleton
    fun provideCoinRepository(api: CoinPaprikaApi): CoinRepository =
        CoinRepositoryImpl(api = api)
}