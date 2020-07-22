package com.android.own.healcorona.data.remote


import com.android.healcorona.data.remote.GlobalNetworkService
import com.android.healcorona.data.remote.IndiaNetworkService
import com.android.own.healcorona.BuildConfig
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit

object Networking {

    private const val NETWORK_CALL_TIMEOUT = 60

    private const val BASE_API_INDIA_URL = "https://api.covid19india.org/"
    private const val BASE_API_GLOBAL_URL = "https://api.covid19api.com/"

    fun create(cacheDir: File, cacheSize: Long): IndiaNetworkService {
        return Retrofit.Builder()
            .baseUrl(BASE_API_INDIA_URL)
            .client(
                OkHttpClient.Builder()
                    .cache(Cache(cacheDir, cacheSize))
                    .addInterceptor(HttpLoggingInterceptor()
                        .apply {
                            level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
                            else HttpLoggingInterceptor.Level.NONE
                        })
                    .readTimeout(NETWORK_CALL_TIMEOUT.toLong(), TimeUnit.SECONDS)
                    .writeTimeout(NETWORK_CALL_TIMEOUT.toLong(), TimeUnit.SECONDS)
                    .build()
            )
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(IndiaNetworkService::class.java)
    }

    fun globalCreate(cacheDir: File, cacheSize: Long): GlobalNetworkService {
        return Retrofit.Builder()
            .baseUrl(BASE_API_GLOBAL_URL)
            .client(
                OkHttpClient.Builder()
                    .cache(Cache(cacheDir, cacheSize))
                    .addInterceptor(HttpLoggingInterceptor()
                        .apply {
                            level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
                            else HttpLoggingInterceptor.Level.NONE
                        })
                    .readTimeout(NETWORK_CALL_TIMEOUT.toLong(), TimeUnit.SECONDS)
                    .writeTimeout(NETWORK_CALL_TIMEOUT.toLong(), TimeUnit.SECONDS)
                    .build()
            )
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(GlobalNetworkService::class.java)
    }
}