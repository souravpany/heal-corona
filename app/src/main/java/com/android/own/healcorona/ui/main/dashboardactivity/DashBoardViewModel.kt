package com.android.own.healcorona.ui.main.dashboardactivity

import androidx.lifecycle.MutableLiveData
import com.android.own.healcorona.data.model.DashboardMenu
import com.android.own.healcorona.ui.base.BaseViewModel
import com.android.healcorona.utils.common.Event
import com.android.healcorona.utils.common.Resource
import com.android.healcorona.utils.network.NetworkHelper
import com.android.healcorona.utils.rx.SchedulerProvider
import com.android.own.healcorona.R
import io.reactivex.disposables.CompositeDisposable

class DashBoardViewModel(
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable,
    networkHelper: NetworkHelper
) : BaseViewModel(schedulerProvider, compositeDisposable, networkHelper) {


    val dbMenuLists: MutableLiveData<Resource<List<DashboardMenu>>> = MutableLiveData()

    val indiaUpdatesClicked = MutableLiveData<Event<Boolean>>()
    val globalUpdatesClicked = MutableLiveData<Event<Boolean>>()
    val symptomsClicked = MutableLiveData<Event<Boolean>>()
    val precautionClicked = MutableLiveData<Event<Boolean>>()


    override fun onCreate() {
        dbMenuLists.postValue(Resource.success(getMenuList()))
    }


    fun getMenuList(): ArrayList<DashboardMenu> = ArrayList<DashboardMenu>().apply {
        val indiaUpdateMenu = DashboardMenu()
        indiaUpdateMenu.id = DashboardMenu.Menu.INDIA_UPDATES.id
        indiaUpdateMenu.name = "India Updates";
        indiaUpdateMenu.image = R.drawable.ic_india
        add(indiaUpdateMenu)

        val coronaUpdateMenu = DashboardMenu()
        coronaUpdateMenu.id = DashboardMenu.Menu.WORLD_UPDATES.id
        coronaUpdateMenu.name = "Global Updates"
        coronaUpdateMenu.image = R.drawable.ic_world
        add(coronaUpdateMenu)

        val symptomsMenu = DashboardMenu()
        symptomsMenu.id = DashboardMenu.Menu.SYMPTOMS.id
        symptomsMenu.name = "Symptoms"
        symptomsMenu.image = R.drawable.ic_cough
        add(symptomsMenu)

        val precautionsMenu = DashboardMenu()
        precautionsMenu.id = DashboardMenu.Menu.PRECAUTIONS.id
        precautionsMenu.name = "Precautions"
        precautionsMenu.image = R.drawable.ic_air_mask
        add(precautionsMenu)
    }

    fun onIndiaUpdateSelected() {
        indiaUpdatesClicked.postValue(Event(true))
    }

    fun onGlobalUpdateSelected() {
        globalUpdatesClicked.postValue(Event(true))
    }

    fun onSymptomsSelected() {
        symptomsClicked.postValue(Event(true))
    }

    fun onPrecautionsSelected() {
        precautionClicked.postValue(Event(true))
    }

}
