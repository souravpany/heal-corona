package com.android.own.healcorona.ui.precautions.adapter

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.android.own.healcorona.data.model.PrecautionsData
import com.android.own.healcorona.ui.base.BaseItemViewModel
import com.android.healcorona.utils.network.NetworkHelper
import com.android.healcorona.utils.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class PrecautionItemViewModel @Inject constructor(
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable,
    networkHelper: NetworkHelper
) : BaseItemViewModel<PrecautionsData>(schedulerProvider, compositeDisposable, networkHelper) {


    val precautionName: LiveData<String> = Transformations.map(data) { it.name }

    val precautionImage: LiveData<Int> = Transformations.map(data) { it.image }


    override fun onCreate() {

    }
}