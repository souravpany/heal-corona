package com.android.own.healcorona.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 *Created by Sourav K.P on 21-04-2020
 */
data class CaseTimeSeriesData(

    @Expose
    @SerializedName("dailyconfirmed")
    val dailyConfirmed: String,

    @Expose
    @SerializedName("dailydeceased")
    val dailyDeceased: String,

    @Expose
    @SerializedName("dailyrecovered")
    val dailyRecovered: String,

    @Expose
    @SerializedName("date")
    val date: String,

    @Expose
    @SerializedName("totalconfirmed")
    val totalConfirmed: String,

    @Expose
    @SerializedName("totaldeceased")
    val totalDeceased: String,

    @Expose
    @SerializedName("totalrecovered")
    val totalRecovered: String

)

