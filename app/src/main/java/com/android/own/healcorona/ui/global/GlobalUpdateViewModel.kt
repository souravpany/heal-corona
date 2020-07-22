package com.android.own.healcorona.ui.global

import androidx.lifecycle.MutableLiveData
import com.android.own.healcorona.data.model.Countries
import com.android.own.healcorona.data.model.Global
import com.android.own.healcorona.data.repository.GlobalDataRepository
import com.android.own.healcorona.ui.base.BaseViewModel
import com.android.healcorona.utils.common.Resource
import com.android.healcorona.utils.network.NetworkHelper
import com.android.healcorona.utils.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable

class GlobalUpdateViewModel(
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable,
    networkHelper: NetworkHelper,
    private val countriesDataList: ArrayList<Countries>,
    private val globalDataRepository: GlobalDataRepository
) : BaseViewModel(schedulerProvider, compositeDisposable, networkHelper) {


    val loading: MutableLiveData<Boolean> = MutableLiveData()

    val countriesDataLists: MutableLiveData<Resource<List<Countries>>> = MutableLiveData()
    val filterCountriesDataLists: MutableLiveData<Resource<List<Countries>>> = MutableLiveData()
    val countriesTotalData: MutableLiveData<Resource<Global>> = MutableLiveData()


    override fun onCreate() {

        if (checkInternetConnectionWithMessage()) {
            loading.postValue(true)
            compositeDisposable.addAll(
                globalDataRepository.fetchIndiaStateDataList()
                    ?.subscribeOn(schedulerProvider.io())
                    ?.subscribe(
                        {
                            val totalObject = it.global
                            countriesDataList.addAll(it.countries)
                            countriesDataLists.postValue(Resource.success(it.countries))
                            countriesTotalData.postValue(Resource.success(totalObject))
                            loading.postValue(false)
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
        val dataList = countriesDataList.filter { it.country.contains(queryString, true) }
        filterCountriesDataLists.postValue(Resource.success(dataList))
    }

}
