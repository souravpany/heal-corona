package com.android.own.healcorona.ui.india

import androidx.lifecycle.MutableLiveData
import com.android.own.healcorona.data.model.StateWiseData
import com.android.own.healcorona.data.repository.IndiaStateDataRepository
import com.android.own.healcorona.ui.base.BaseViewModel
import com.android.healcorona.utils.common.Resource
import com.android.healcorona.utils.network.NetworkHelper
import com.android.healcorona.utils.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable

class IndiaUpdateViewModel(
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable,
    networkHelper: NetworkHelper,
    private val stateWiseDataList: ArrayList<StateWiseData>,
    private val indiaStateDataRepository: IndiaStateDataRepository
) : BaseViewModel(schedulerProvider, compositeDisposable, networkHelper) {


    val loading: MutableLiveData<Boolean> = MutableLiveData()

    val stateWiseDataLists: MutableLiveData<Resource<List<StateWiseData>>> = MutableLiveData()
    val filterStateWiseDataLists: MutableLiveData<Resource<List<StateWiseData>>> = MutableLiveData()
    val indiaTotalData: MutableLiveData<Resource<StateWiseData>> = MutableLiveData()


    override fun onCreate() {

        if (checkInternetConnectionWithMessage()) {
            loading.postValue(true)
            compositeDisposable.addAll(
                indiaStateDataRepository.fetchIndiaStateDataList()
                    ?.subscribeOn(schedulerProvider.io())
                    ?.subscribe(
                        {
                            val totalObject = it.stateWiseData[0]
                            it.stateWiseData.removeAt(0) // removing the 1st object becoz that is belongs to all state details
                            stateWiseDataList.addAll(it.stateWiseData)
                            loading.postValue(false)
                            stateWiseDataLists.postValue(Resource.success(it.stateWiseData))
                            indiaTotalData.postValue(Resource.success(totalObject))
                        },
                        {
                            handleNetworkError(it)
                            loading.postValue(false)
                        }

                    )

            )
        }

    }

    /*
    * filter full data
    *
    * */
    fun filterList(queryString: String) {
        val dataList = stateWiseDataList.filter { it.state.contains(queryString, true) }
        filterStateWiseDataLists.postValue(Resource.success(dataList))
    }

}
