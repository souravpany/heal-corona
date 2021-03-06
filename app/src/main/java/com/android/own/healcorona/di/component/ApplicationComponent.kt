package com.android.own.healcorona.di.component


import android.app.Application
import android.content.Context
import com.android.own.healcorona.HCApplication
import com.android.healcorona.data.remote.GlobalNetworkService
import com.android.healcorona.data.remote.IndiaNetworkService
import com.android.own.healcorona.di.ApplicationContext
import com.android.own.healcorona.di.module.ApplicationModule
import com.android.healcorona.utils.network.NetworkHelper
import com.android.healcorona.utils.rx.SchedulerProvider
import dagger.Component
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {


    fun inject(app: HCApplication)

    fun getApplication(): Application

    @ApplicationContext
    fun getContext(): Context


    /**
     * These methods are written in ApplicationComponent because the instance of
     * NetworkService is singleton and is maintained in the ApplicationComponent's implementation by Dagger
     * For NetworkService singleton instance to be accessible to say DummyActivity's DummyViewModel
     * this ApplicationComponent must expose a method that returns NetworkService instance
     * This method will be called when NetworkService is injected in DummyViewModel.
     * Also, in ActivityComponent you can find dependencies = [ApplicationComponent::class] to link this relationship
     */
    fun getIndiaNetworkService(): IndiaNetworkService

    fun getGlobalNetworkService(): GlobalNetworkService


    fun getNetworkHelper(): NetworkHelper


    fun getSchedulerProvider(): SchedulerProvider

    fun getCompositeDisposable(): CompositeDisposable

}
