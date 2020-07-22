package com.android.healcorona.data.remote


import com.android.own.healcorona.data.remote.response.GlobalData
import io.reactivex.Single
import retrofit2.http.GET
import javax.inject.Singleton


@Singleton
interface GlobalNetworkService {

    @GET(Endpoints.GLOBAL_LIST)
    fun doGlobalDataListCall(
    ): Single<GlobalData>

}
