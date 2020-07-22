package com.android.own.healcorona.ui.india

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.own.healcorona.R
import com.android.own.healcorona.di.component.ActivityComponent
import com.android.own.healcorona.ui.base.BaseActivity
import com.android.own.healcorona.ui.india.adapter.IndiaStateDataListAdapter
import kotlinx.android.synthetic.main.activity_india_update.*
import kotlinx.android.synthetic.main.activity_india_update.toolBar
import javax.inject.Inject

class IndiaUpdateActivity : BaseActivity<IndiaUpdateViewModel>() {


    @Inject
    lateinit var linearLayoutManager: LinearLayoutManager


    @Inject
    lateinit var indiaStateDataListAdapter: IndiaStateDataListAdapter


    override fun provideLayoutId(): Int = R.layout.activity_india_update


    override fun injectDependencies(activityComponent: ActivityComponent) {
        activityComponent.inject(this)
    }

    override fun setupView(savedInstanceState: Bundle?) {
        setSupportActionBar(toolBar)


        rvState.apply {
            layoutManager = linearLayoutManager
            adapter = indiaStateDataListAdapter
        }


        toolBar.setNavigationOnClickListener { finish() }


        etSearch.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable?) {}


            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}


            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                viewModel.filterList(s.toString().trim())
                if (s.toString().isNotEmpty()) {
                    ivClose.visibility = View.VISIBLE
                } else {
                    ivClose.visibility = View.INVISIBLE
                }

            }

        })


        ivClose.setOnClickListener {
            etSearch.text?.clear()
        }

    }


    override fun setupObservers() {
        super.setupObservers()

        viewModel.loading.observe(this, Observer {
            progress_horizontal.visibility = if (it) View.VISIBLE else View.GONE
        })

        viewModel.indiaTotalData.observe(this, Observer {

            it.data?.run {

                tvTotalCases.text = this.confirmed
                tvRecovered.text = this.recovered
                tvDeaths.text = this.deaths
            }

        })


        viewModel.stateWiseDataLists.observe(this, Observer {
            it.data?.run {

                indiaStateDataListAdapter.appendData(this)

            }
        })

        viewModel.filterStateWiseDataLists.observe(this, Observer {
            it.data?.run {

                indiaStateDataListAdapter.updateList(this)

            }
        })

    }
}
