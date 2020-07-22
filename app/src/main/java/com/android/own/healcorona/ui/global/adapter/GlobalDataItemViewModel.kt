package com.android.own.healcorona.ui.global.adapter

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.android.own.healcorona.data.model.Countries
import com.android.own.healcorona.ui.base.BaseItemViewModel
import com.android.healcorona.utils.network.NetworkHelper
import com.android.healcorona.utils.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class GlobalDataItemViewModel @Inject constructor(
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable,
    networkHelper: NetworkHelper
) : BaseItemViewModel<Countries>(schedulerProvider, compositeDisposable, networkHelper) {


    val countryCode: LiveData<String> = Transformations.map(data) { it.countryCode }

    val countryName: LiveData<String> = Transformations.map(data) { it.country }

    val totalConfirmed: LiveData<String> = Transformations.map(data) { it.totalConfirmed.toString() }

    val totalRecovered: LiveData<String> = Transformations.map(data) { it.totalRecovered.toString() }

    val newConfirmed: LiveData<String> = Transformations.map(data) { it.newConfirmed.toString() }

    val totalDeaths: LiveData<String> = Transformations.map(data) { it.totalDeaths.toString() }


    override fun onCreate() {

    }
}