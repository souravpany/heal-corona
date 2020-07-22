package com.android.own.healcorona.ui.main.dashboardactivity

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.own.healcorona.R
import com.android.own.healcorona.di.component.ActivityComponent
import com.android.own.healcorona.ui.base.BaseActivity
import com.android.own.healcorona.ui.global.GlobalUpdateActivity
import com.android.own.healcorona.ui.india.IndiaUpdateActivity
import com.android.own.healcorona.ui.main.dashboardactivity.adapter.DBMenuListAdapter
import com.android.own.healcorona.ui.precautions.PrecautionsActivity
import com.android.own.healcorona.ui.symptoms.SymptomsActivity
import kotlinx.android.synthetic.main.activity_dash_board.*
import javax.inject.Inject

/**
 *Created by Sourav K.P on 20-04-2020
 */
class DashBoardActivity : BaseActivity<DashBoardViewModel>() {

    @Inject
    lateinit var gridLayoutManager: GridLayoutManager

    @Inject
    lateinit var dbMenuListAdapter: DBMenuListAdapter


    override fun provideLayoutId(): Int = R.layout.activity_dash_board

    override fun injectDependencies(activityComponent: ActivityComponent) {
        activityComponent.inject(this)
    }

    override fun setupView(savedInstanceState: Bundle?) {
        setSupportActionBar(toolBar)

        rvMenu.apply {
            layoutManager = gridLayoutManager as RecyclerView.LayoutManager?
            adapter = dbMenuListAdapter
        }


        rvMenu.addOnItemClickListener(object : OnItemClickListener {
            override fun onItemClicked(position: Int, view: View) {

                when (viewModel.getMenuList()[position].id) {
                    1 -> {
                        viewModel.onIndiaUpdateSelected()
                    }
                    2 -> {
                        viewModel.onGlobalUpdateSelected()
                    }
                    3 -> {
                        viewModel.onSymptomsSelected()
                    }
                    4 -> {
                        viewModel.onPrecautionsSelected()
                    }
                }
            }
        })


    }


    override fun setupObservers() {
        super.setupObservers()

        /**
         * Observe list changes
         */
        viewModel.dbMenuLists.observe(this, Observer {
            it.data?.run {

                dbMenuListAdapter.appendData(this)
            }
        })

        viewModel.indiaUpdatesClicked.observe(this, Observer {
            it.getIfNotHandled()?.run { moveToIndiaUpdateActivity() }
        })

        viewModel.globalUpdatesClicked.observe(this, Observer {
            it.getIfNotHandled()?.run { moveToGlobalUpdateActivity() }
        })

        viewModel.symptomsClicked.observe(this, Observer {
            it.getIfNotHandled()?.run { moveToSymptomsActivity() }
        })

        viewModel.precautionClicked.observe(this, Observer {
            it.getIfNotHandled()?.run { moveToPrecautionActivity() }
        })


    }

    /**
     * Calling India Update Screen
     *
     * */
    private fun moveToIndiaUpdateActivity() {
        startActivity(Intent(applicationContext, IndiaUpdateActivity::class.java))
    }

    /**
     * Calling Global Update Screen
     *
     * */
    private fun moveToGlobalUpdateActivity() {
        startActivity(Intent(applicationContext, GlobalUpdateActivity::class.java))
    }

    /**
     * Calling Symptoms Screen
     *
     * */
    private fun moveToSymptomsActivity() {
        startActivity(Intent(applicationContext, SymptomsActivity::class.java))
    }

    /**
     * Calling Precaution Screen
     *
     * */
    private fun moveToPrecautionActivity() {

        startActivity(Intent(applicationContext, PrecautionsActivity::class.java))
    }
}
