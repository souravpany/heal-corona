package com.android.own.healcorona.ui.precautions

import androidx.lifecycle.MutableLiveData
import com.android.own.healcorona.data.model.PrecautionsData
import com.android.own.healcorona.ui.base.BaseViewModel
import com.android.healcorona.utils.common.Resource
import com.android.healcorona.utils.network.NetworkHelper
import com.android.healcorona.utils.rx.SchedulerProvider
import com.android.own.healcorona.R
import io.reactivex.disposables.CompositeDisposable

/**
 *Created by Sourav K.P on 21-04-2020
 */

class PrecautionsViewModel(
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable,
    networkHelper: NetworkHelper
) : BaseViewModel(schedulerProvider, compositeDisposable, networkHelper) {

    val precautionsList: MutableLiveData<Resource<List<PrecautionsData>>> = MutableLiveData()


    override fun onCreate() {
        precautionsList.postValue(Resource.success(getPrecautionsList()))
    }


    private fun getPrecautionsList() = ArrayList<PrecautionsData>().apply {
        val precaution1 = PrecautionsData(
            name = "Stay away from people and maintain social distancing.",
            image = R.drawable.ic_distance
        )
        add(precaution1)

        val precaution2 = PrecautionsData(
            name = "Wash your hands frequently with soap, at least for 20 seconds.",
            image = R.drawable.ic_washhands
        )
        add(precaution2)

        val precaution3 = PrecautionsData(
            name = "Avoid frequently touching your nose,eyes and face.",
            image = R.drawable.ic_distance
        )
        add(precaution3)

        val precaution4 = PrecautionsData(
            name = "Stay at home if you feel sick.",
            image = R.drawable.ic_distance
        )
        add(precaution4)

        val precaution5 = PrecautionsData(
            name = "Use handkerchief while sneezing and coughing.",
            image = R.drawable.ic_cough
        )
        add(precaution5)
    }


}