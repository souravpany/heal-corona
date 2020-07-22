package com.android.own.healcorona.ui.india.adapter

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.android.own.healcorona.data.model.StateWiseData
import com.android.own.healcorona.ui.base.BaseItemViewModel
import com.android.healcorona.utils.network.NetworkHelper
import com.android.healcorona.utils.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class IndiaStateDataItemViewModel @Inject constructor(
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable,
    networkHelper: NetworkHelper
) : BaseItemViewModel<StateWiseData>(schedulerProvider, compositeDisposable, networkHelper) {


    val stateCode: LiveData<String> = Transformations.map(data) { it.statecode }

    val stateName: LiveData<String> = Transformations.map(data) { it.state }

    val recovered: LiveData<String> = Transformations.map(data) { it.recovered }

    val lastUpdatedTime: LiveData<String> = Transformations.map(data) { it.lastupdatedtime }

    val deaths: LiveData<String> = Transformations.map(data) { it.deaths }

    val confirmed: LiveData<String> = Transformations.map(data) { it.confirmed }

    val active: LiveData<String> = Transformations.map(data) { it.active }


    override fun onCreate() {

    }
}