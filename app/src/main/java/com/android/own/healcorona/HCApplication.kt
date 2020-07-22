package com.android.own.healcorona

import android.app.Application
import com.android.own.healcorona.di.component.ApplicationComponent
import com.android.own.healcorona.di.component.DaggerApplicationComponent
import com.android.own.healcorona.di.module.ApplicationModule

class HCApplication : Application() {

    lateinit var applicationComponent: ApplicationComponent


    override fun onCreate() {
        super.onCreate()
        injectDependencies()

    }

    private fun injectDependencies() {
        applicationComponent = DaggerApplicationComponent
            .builder()
            .applicationModule(ApplicationModule(this))
            .build()
        applicationComponent.inject(this)
    }


}
