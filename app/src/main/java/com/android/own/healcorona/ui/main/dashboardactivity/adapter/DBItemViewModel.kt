package com.android.own.healcorona.ui.main.dashboardactivity.adapter

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.android.own.healcorona.data.model.DashboardMenu
import com.android.own.healcorona.ui.base.BaseItemViewModel
import com.android.healcorona.utils.network.NetworkHelper
import com.android.healcorona.utils.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class DBItemViewModel @Inject constructor(
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable,
    networkHelper: NetworkHelper
) : BaseItemViewModel<DashboardMenu>(schedulerProvider, compositeDisposable, networkHelper) {


    val menuName: LiveData<String> = Transformations.map(data) { it.name }

    val menuImage: LiveData<Int> = Transformations.map(data) { it.image }


    override fun onCreate() {

    }
}