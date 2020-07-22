package com.android.own.healcorona.data.remote.response

import com.android.own.healcorona.data.model.Countries
import com.android.own.healcorona.data.model.Global
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 *Created by Sourav K.P on 23-04-2020
 */
data class GlobalData(
    @Expose
    @SerializedName("Global")
    val global: Global,

    @Expose
    @SerializedName("Countries")
    val countries: List<Countries>,

    @Expose
    @SerializedName("Date")
    val date: String
)