package com.android.healcorona.data.remote


import com.android.own.healcorona.data.remote.response.IndiaData
import io.reactivex.Single
import retrofit2.http.GET
import javax.inject.Singleton


@Singleton
interface IndiaNetworkService {

    @GET(Endpoints.INDIA_LIST)
    fun doIndiaDataListCall(
    ): Single<IndiaData>

}
