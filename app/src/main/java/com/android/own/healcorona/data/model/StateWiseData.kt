package com.android.own.healcorona.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 *Created by Sourav K.P on 21-04-2020
 */
data class StateWiseData(

    @Expose
    @SerializedName("active")
    val active: String,

    @Expose
    @SerializedName("confirmed")
    val confirmed: String,

    @Expose
    @SerializedName("deaths")
    val deaths: String,

    @Expose
    @SerializedName("deltaconfirmed")
    val deltaconfirmed: String,

    @Expose
    @SerializedName("deltadeaths")
    val deltadeaths: String,

    @Expose
    @SerializedName("deltarecovered")
    val deltarecovered: String,

    @Expose
    @SerializedName("lastupdatedtime")
    val lastupdatedtime: String,

    @Expose
    @SerializedName("recovered")
    val recovered: String,

    @Expose
    @SerializedName("state")
    val state: String,

    @Expose
    @SerializedName("statecode")
    val statecode: String,

    @Expose
    @SerializedName("statenotes")
    val statenotes: String

)

