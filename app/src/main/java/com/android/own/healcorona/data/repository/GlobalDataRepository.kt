package com.android.own.healcorona.data.repository


import com.android.healcorona.data.remote.GlobalNetworkService
import com.android.own.healcorona.data.remote.response.GlobalData
import io.reactivex.Single
import javax.inject.Inject

class GlobalDataRepository @Inject constructor(
    private val globalNetworkService: GlobalNetworkService
) {

    fun fetchIndiaStateDataList(): Single<GlobalData>? {
        return globalNetworkService.doGlobalDataListCall(
        ).map { it }
    }
}