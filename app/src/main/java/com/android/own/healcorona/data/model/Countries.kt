package com.android.own.healcorona.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 *Created by Sourav K.P on 23-04-2020
 */
data class Countries(

    @Expose
    @SerializedName("Country")
    val country: String,

    @Expose
    @SerializedName("CountryCode")
    val countryCode: String,

    @Expose
    @SerializedName("Slug")
    val slug: String,

    @Expose
    @SerializedName("NewConfirmed")
    val newConfirmed: Int,

    @Expose
    @SerializedName("TotalConfirmed")
    val totalConfirmed: Int,

    @Expose
    @SerializedName("NewDeaths")
    val newDeaths: Int,

    @Expose
    @SerializedName("TotalDeaths")
    val totalDeaths: Int,

    @Expose
    @SerializedName("NewRecovered")
    val newRecovered: Int,

    @Expose
    @SerializedName("TotalRecovered")
    val totalRecovered: Int,

    @Expose
    @SerializedName("Date")
    val date: String
)