package com.android.own.healcorona.data.remote.response

import com.android.own.healcorona.data.model.CaseTimeSeriesData
import com.android.own.healcorona.data.model.StateWiseData
import com.android.own.healcorona.data.model.TestedData
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 *Created by Sourav K.P on 23-04-2020
 */
data class IndiaData(
    @Expose
    @SerializedName("case_time_series")
    val caseTimeSeriesData: ArrayList<CaseTimeSeriesData>,

    @Expose
    @SerializedName("statewise")
    val stateWiseData: ArrayList<StateWiseData>,

    @Expose
    @SerializedName("tested")
    val tested: ArrayList<TestedData>
)