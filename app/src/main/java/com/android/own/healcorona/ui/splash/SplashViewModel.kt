package com.android.own.healcorona.ui.splash

import android.os.Handler
import androidx.lifecycle.MutableLiveData
import com.android.own.healcorona.ui.base.BaseViewModel
import com.android.healcorona.utils.common.Event
import com.android.healcorona.utils.network.NetworkHelper
import com.android.healcorona.utils.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable

class SplashViewModel(
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable,
    networkHelper: NetworkHelper
) : BaseViewModel(schedulerProvider, compositeDisposable, networkHelper) {

    private val splashTimeOut: Long = 4040 // 3 sec
    val launchDashActivity: MutableLiveData<Event<Map<String, String>>> = MutableLiveData()


    override fun onCreate() {

        Handler().postDelayed({
            launchDashActivity.postValue(Event(emptyMap()))
        }, splashTimeOut)
    }
}