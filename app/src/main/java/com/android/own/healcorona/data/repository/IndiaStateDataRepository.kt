package com.android.own.healcorona.data.repository


import com.android.healcorona.data.remote.IndiaNetworkService
import com.android.own.healcorona.data.remote.response.IndiaData
import io.reactivex.Single
import javax.inject.Inject

class IndiaStateDataRepository @Inject constructor(
    private val indiaNetworkService: IndiaNetworkService
) {

    fun fetchIndiaStateDataList(): Single<IndiaData>? {
        return indiaNetworkService.doIndiaDataListCall(
        ).map { it }
    }
}