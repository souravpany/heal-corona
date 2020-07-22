package com.android.own.healcorona.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 *Created by Sourav K.P on 23-04-2020
 */
data class TestedData(

    @Expose
    @SerializedName("positivecasesfromsamplesreported")
    val positivecasesfromsamplesreported: String,

    @Expose
    @SerializedName("samplereportedtoday")
    val samplereportedtoday: String,

    @Expose
    @SerializedName("source")
    val source: String,

    @Expose
    @SerializedName("testpositivityrate")
    val testpositivityrate: String,

    @Expose
    @SerializedName("testsconductedbyprivatelabs")
    val testsconductedbyprivatelabs: String,

    @Expose
    @SerializedName("totalindividualstested")
    val totalindividualstested: String,

    @Expose
    @SerializedName("totalpositivecases")
    val totalpositivecases: String,

    @Expose
    @SerializedName("totalsamplestested")
    val totalsamplestested: String,

    @Expose
    @SerializedName("updatetimestamp")
    val updatetimestamp: String
)

