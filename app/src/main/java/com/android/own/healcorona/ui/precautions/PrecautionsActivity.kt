package com.android.own.healcorona.ui.precautions

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.own.healcorona.R
import com.android.own.healcorona.di.component.ActivityComponent
import com.android.own.healcorona.ui.base.BaseActivity
import com.android.own.healcorona.ui.precautions.adapter.PrecautionListAdapter
import kotlinx.android.synthetic.main.activity_precautions.*
import javax.inject.Inject

/**
 *Created by Sourav K.P on 21-04-2020
 */

class PrecautionsActivity : BaseActivity<PrecautionsViewModel>() {

    @Inject
    lateinit var linearLayoutManager: LinearLayoutManager

    @Inject
    lateinit var precautionListAdapter: PrecautionListAdapter


    override fun provideLayoutId(): Int = R.layout.activity_precautions


    override fun injectDependencies(activityComponent: ActivityComponent) {
        activityComponent.inject(this)

    }

    override fun setupView(savedInstanceState: Bundle?) {
        setSupportActionBar(toolBar)

        toolBar.setNavigationOnClickListener { finish() }


        rvPrecautions.apply {
            layoutManager = linearLayoutManager
            adapter = precautionListAdapter
        }

    }


    override fun setupObservers() {
        super.setupObservers()

        viewModel.precautionsList.observe(this, Observer {
            it.data?.run {

                precautionListAdapter.appendData(this)
            }
        })
    }

}
