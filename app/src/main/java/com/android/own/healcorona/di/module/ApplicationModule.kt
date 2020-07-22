package com.android.own.healcorona.di.module

import android.app.Application
import android.content.Context
import com.android.own.healcorona.HCApplication
import com.android.healcorona.data.remote.GlobalNetworkService
import com.android.healcorona.data.remote.IndiaNetworkService
import com.android.own.healcorona.data.remote.Networking
import com.android.own.healcorona.di.ApplicationContext
import com.android.healcorona.utils.network.NetworkHelper
import com.android.healcorona.utils.rx.RxSchedulerProvider
import com.android.healcorona.utils.rx.SchedulerProvider
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

@Module
class ApplicationModule(private val application: HCApplication) {

    @Singleton
    @Provides
    fun provideApplication(): Application = application

    @Provides
    @Singleton
    @ApplicationContext
    fun provideContext(): Context = application

    /**
     * Network India service provider fun for calling respective APIs
     */

    @Provides
    @Singleton
    fun provideNetworkService(): IndiaNetworkService =
        Networking.create(application.cacheDir, (10 * 1024 * 1024).toLong())

    /**
     * Network Global service provider fun for calling respective APIs
     */

    @Provides
    @Singleton
    fun provideGlobalNetworkService(): GlobalNetworkService =
        Networking.globalCreate(
            application.cacheDir,
            (10 * 1024 * 1024).toLong()
        )

    /**
     * Network help provider fun for creating bridge and checking network related issue
     */

    @Provides
    @Singleton
    fun provideNetworkHelper(): NetworkHelper = NetworkHelper(application)


    /**
     * Since this function do not have @Singleton then each time CompositeDisposable is injected
     * then a new instance of CompositeDisposable will be provided
     */
    @Provides
    fun provideCompositeDisposable(): CompositeDisposable = CompositeDisposable()


    @Provides
    fun provideSchedulerProvider(): SchedulerProvider = RxSchedulerProvider()
}
