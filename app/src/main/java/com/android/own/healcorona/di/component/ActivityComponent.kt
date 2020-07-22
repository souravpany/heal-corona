package com.android.own.healcorona.di.component

import com.android.own.healcorona.di.ActivityScope
import com.android.own.healcorona.di.module.ActivityModule
import com.android.own.healcorona.ui.global.GlobalUpdateActivity
import com.android.own.healcorona.ui.india.IndiaUpdateActivity
import com.android.own.healcorona.ui.main.dashboardactivity.DashBoardActivity
import com.android.own.healcorona.ui.precautions.PrecautionsActivity
import com.android.own.healcorona.ui.splash.SplashActivity
import com.android.own.healcorona.ui.symptoms.SymptomsActivity
import dagger.Component

@ActivityScope
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [ActivityModule::class]
)
interface ActivityComponent {

    fun inject(activity: SplashActivity)

    fun inject(activity: DashBoardActivity)

    fun inject(activity: PrecautionsActivity)

    fun inject(activity: SymptomsActivity)

    fun inject(activity: IndiaUpdateActivity)

    fun inject(activity: GlobalUpdateActivity)

}