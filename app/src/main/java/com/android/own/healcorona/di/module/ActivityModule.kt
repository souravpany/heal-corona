package com.android.own.healcorona.di.module

import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.own.healcorona.data.repository.GlobalDataRepository
import com.android.own.healcorona.data.repository.IndiaStateDataRepository
import com.android.own.healcorona.ui.base.BaseActivity
import com.android.own.healcorona.ui.global.GlobalUpdateViewModel
import com.android.own.healcorona.ui.global.adapter.GlobalDataListAdapter
import com.android.own.healcorona.ui.india.IndiaUpdateViewModel
import com.android.own.healcorona.ui.india.adapter.IndiaStateDataListAdapter
import com.android.own.healcorona.ui.main.dashboardactivity.DashBoardViewModel
import com.android.own.healcorona.ui.main.dashboardactivity.adapter.DBMenuListAdapter
import com.android.own.healcorona.ui.precautions.PrecautionsViewModel
import com.android.own.healcorona.ui.precautions.adapter.PrecautionListAdapter
import com.android.own.healcorona.ui.splash.SplashViewModel
import com.android.own.healcorona.ui.symptoms.SymptomsViewModel
import com.android.own.healcorona.ui.symptoms.adapter.SymptomsListAdapter
import com.android.healcorona.utils.ViewModelProviderFactory
import com.android.healcorona.utils.network.NetworkHelper
import com.android.healcorona.utils.rx.SchedulerProvider
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

/**
 * Basically it means that we can pass any class that extends BaseActivity which take
 * BaseViewModel subclass as parameter
 */

@Module
class ActivityModule(private val activity: BaseActivity<*>) {

    @Provides
    fun provideLinearLayoutManager(): LinearLayoutManager = LinearLayoutManager(activity)

    @Provides
    fun provideGridLayoutManager(): GridLayoutManager = GridLayoutManager(activity, 2)

    @Provides
    fun provideTrendingListAdapter() = DBMenuListAdapter(activity.lifecycle, ArrayList())

    @Provides
    fun providePrecautionListAdapter() = PrecautionListAdapter(activity.lifecycle, ArrayList())

    @Provides
    fun provideSymptomsListAdapter() = SymptomsListAdapter(activity.lifecycle, ArrayList())

    @Provides
    fun provideIndiaStateDataListAdapter() =
        IndiaStateDataListAdapter(activity.lifecycle, ArrayList())

    @Provides
    fun provideGlobalDataListAdapter() =
        GlobalDataListAdapter(activity.lifecycle, ArrayList())


    @Provides
    fun provideSplashViewModel(
        schedulerProvider: SchedulerProvider,
        compositeDisposable: CompositeDisposable,
        networkHelper: NetworkHelper
    ): SplashViewModel = ViewModelProviders.of(
        activity, ViewModelProviderFactory(SplashViewModel::class) {
            SplashViewModel(schedulerProvider, compositeDisposable, networkHelper)
            //this lambda creates and return SplashViewModel
        }).get(SplashViewModel::class.java)

    @Provides
    fun provideDashBoardViewModel(
        schedulerProvider: SchedulerProvider,
        compositeDisposable: CompositeDisposable,
        networkHelper: NetworkHelper
    ): DashBoardViewModel = ViewModelProviders.of(
        activity, ViewModelProviderFactory(DashBoardViewModel::class) {
            DashBoardViewModel(schedulerProvider, compositeDisposable, networkHelper)
            //this lambda creates and return DashBoardViewModel
        }).get(DashBoardViewModel::class.java)

    @Provides
    fun providePrecautionsViewModel(
        schedulerProvider: SchedulerProvider,
        compositeDisposable: CompositeDisposable,
        networkHelper: NetworkHelper
    ): PrecautionsViewModel = ViewModelProviders.of(
        activity, ViewModelProviderFactory(PrecautionsViewModel::class) {
            PrecautionsViewModel(schedulerProvider, compositeDisposable, networkHelper)
            //this lambda creates and return PrecautionsViewModel
        }).get(PrecautionsViewModel::class.java)

    @Provides
    fun provideSymptomsViewModel(
        schedulerProvider: SchedulerProvider,
        compositeDisposable: CompositeDisposable,
        networkHelper: NetworkHelper
    ): SymptomsViewModel = ViewModelProviders.of(
        activity, ViewModelProviderFactory(SymptomsViewModel::class) {
            SymptomsViewModel(schedulerProvider, compositeDisposable, networkHelper)
            //this lambda creates and return SymptomsViewModel
        }).get(SymptomsViewModel::class.java)

    @Provides
    fun provideIndiaUpdateViewModel(
        schedulerProvider: SchedulerProvider,
        compositeDisposable: CompositeDisposable,
        networkHelper: NetworkHelper,
        indiaStateDataRepository: IndiaStateDataRepository
    ): IndiaUpdateViewModel = ViewModelProviders.of(
        activity, ViewModelProviderFactory(IndiaUpdateViewModel::class) {
            IndiaUpdateViewModel(
                schedulerProvider, compositeDisposable, networkHelper, ArrayList(),
                indiaStateDataRepository
            )
            //this lambda creates and return IndiaUpdateViewModel
        }).get(IndiaUpdateViewModel::class.java)

    @Provides
    fun provideGlobalUpdateViewModel(
        schedulerProvider: SchedulerProvider,
        compositeDisposable: CompositeDisposable,
        networkHelper: NetworkHelper,
        globalDataRepository: GlobalDataRepository
    ): GlobalUpdateViewModel = ViewModelProviders.of(
        activity, ViewModelProviderFactory(GlobalUpdateViewModel::class) {
            GlobalUpdateViewModel(
                schedulerProvider, compositeDisposable, networkHelper, ArrayList(),
                globalDataRepository
            )
            //this lambda creates and return IndiaUpdateViewModel
        }).get(GlobalUpdateViewModel::class.java)


}