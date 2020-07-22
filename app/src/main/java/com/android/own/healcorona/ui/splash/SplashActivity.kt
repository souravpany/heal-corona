package com.android.own.healcorona.ui.splash

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.Observer
import com.android.own.healcorona.di.component.ActivityComponent
import com.android.own.healcorona.ui.base.BaseActivity
import com.android.own.healcorona.ui.main.dashboardactivity.DashBoardActivity
import com.android.healcorona.utils.common.Event
import com.android.own.healcorona.R

class SplashActivity : BaseActivity<SplashViewModel>() {

    override fun provideLayoutId(): Int = R.layout.activity_splash_screen

    override fun injectDependencies(activityComponent: ActivityComponent) {
        activityComponent.inject(this)
    }

    override fun setupView(savedInstanceState: Bundle?) {
    }

    override fun setupObservers() {
        super.setupObservers()

        viewModel.launchDashActivity.observe(this, Observer<Event<Map<String, String>>> {
            it.getIfNotHandled()?.run {
                startActivity(Intent(applicationContext, DashBoardActivity::class.java))
                finish()
            }
        })
    }
}