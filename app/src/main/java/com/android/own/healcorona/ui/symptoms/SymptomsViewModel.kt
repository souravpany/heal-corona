package com.android.own.healcorona.ui.symptoms

import androidx.lifecycle.MutableLiveData
import com.android.own.healcorona.data.model.SymptomsData
import com.android.own.healcorona.ui.base.BaseViewModel
import com.android.healcorona.utils.common.Resource
import com.android.healcorona.utils.network.NetworkHelper
import com.android.healcorona.utils.rx.SchedulerProvider
import com.android.own.healcorona.R
import io.reactivex.disposables.CompositeDisposable

class SymptomsViewModel(
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable,
    networkHelper: NetworkHelper
) : BaseViewModel(schedulerProvider, compositeDisposable, networkHelper) {


    val symptomsList: MutableLiveData<Resource<List<SymptomsData>>> = MutableLiveData()


    override fun onCreate() {
        symptomsList.postValue(Resource.success(getSymptomsList()))
    }


    private fun getSymptomsList() = ArrayList<SymptomsData>().apply {
        val symptom1 = SymptomsData(
            name = "Fever",
            image = R.drawable.ic_fever
        )
        add(symptom1)

        val symptom2 = SymptomsData(
            name = "Cough",
            image = R.drawable.ic_cough
        )
        add(symptom2)

        val symptom3 = SymptomsData(
            name = "Shortness of breath or difficulty breathing",
            image = R.drawable.ic_cough
        )
        add(symptom3)

        val symptom4 = SymptomsData(
            name = "Tiredness",
            image = R.drawable.ic_tired
        )
        add(symptom4)

        val symptom5 = SymptomsData(
            name = "Aches",
            image = R.drawable.ic_cough
        )
        add(symptom5)

        val symptom6 = SymptomsData(
            name = "Runny nose",
            image = R.drawable.ic_nose
        )
        add(symptom6)

        val symptom7 = SymptomsData(
            name = "Sore throat",
            image = R.drawable.ic_sorethroat
        )
        add(symptom7)
    }
}
