package com.android.own.healcorona.ui.symptoms

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.own.healcorona.di.component.ActivityComponent
import com.android.own.healcorona.ui.base.BaseActivity
import com.android.own.healcorona.ui.symptoms.adapter.SymptomsListAdapter
import com.android.own.healcorona.R
import kotlinx.android.synthetic.main.activity_symptoms.*
import javax.inject.Inject

class SymptomsActivity : BaseActivity<SymptomsViewModel>() {

    @Inject
    lateinit var linearLayoutManager: LinearLayoutManager

    @Inject
    lateinit var symptomsListAdapter: SymptomsListAdapter


    override fun provideLayoutId(): Int = R.layout.activity_symptoms

    override fun injectDependencies(activityComponent: ActivityComponent) {
        activityComponent.inject(this)
    }

    override fun setupView(savedInstanceState: Bundle?) {

        setSupportActionBar(toolBar)

        toolBar.setNavigationOnClickListener { finish() }


        rvSymptoms.apply {
            layoutManager = linearLayoutManager
            adapter = symptomsListAdapter
        }

    }

    override fun setupObservers() {
        super.setupObservers()

        viewModel.symptomsList.observe(this, Observer {
            it.data?.run {

                symptomsListAdapter.appendData(this)
            }
        })
    }
}
