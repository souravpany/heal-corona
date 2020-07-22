package com.android.own.healcorona.ui.symptoms.adapter

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.android.own.healcorona.data.model.SymptomsData
import com.android.own.healcorona.ui.base.BaseItemViewModel
import com.android.healcorona.utils.network.NetworkHelper
import com.android.healcorona.utils.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class SymptomsItemViewModel @Inject constructor(
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable,
    networkHelper: NetworkHelper
) : BaseItemViewModel<SymptomsData>(schedulerProvider, compositeDisposable, networkHelper) {


    val symptomsName: LiveData<String> = Transformations.map(data) { it.name }

    val symptomsImage: LiveData<Int> = Transformations.map(data) { it.image }


    override fun onCreate() {

    }
}