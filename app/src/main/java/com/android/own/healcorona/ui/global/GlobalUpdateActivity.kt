package com.android.own.healcorona.ui.global

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.own.healcorona.R
import com.android.own.healcorona.di.component.ActivityComponent
import com.android.own.healcorona.ui.base.BaseActivity
import com.android.own.healcorona.ui.global.adapter.GlobalDataListAdapter
import kotlinx.android.synthetic.main.activity_global_update.*
import javax.inject.Inject

class GlobalUpdateActivity : BaseActivity<GlobalUpdateViewModel>() {


    @Inject
    lateinit var linearLayoutManager: LinearLayoutManager


    @Inject
    lateinit var globalDataListAdapter: GlobalDataListAdapter


    override fun provideLayoutId(): Int = R.layout.activity_global_update


    override fun injectDependencies(activityComponent: ActivityComponent) {
        activityComponent.inject(this)
    }

    override fun setupView(savedInstanceState: Bundle?) {

        setSupportActionBar(toolBar)

        rvCountryData.apply {
            layoutManager = linearLayoutManager
            adapter = globalDataListAdapter
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


        viewModel.countriesTotalData.observe(this, Observer {

            it.data?.run {

                tvTotalCases.text = this.totalConfirmed.toString()
                tvRecovered.text = this.totalRecovered.toString()
                tvDeaths.text = this.totalDeaths.toString()
            }

        })


        viewModel.countriesDataLists.observe(this, Observer {
            it.data?.run {

                globalDataListAdapter.appendData(this)

            }
        })

        viewModel.filterCountriesDataLists.observe(this, Observer {
            it.data?.run {

                globalDataListAdapter.updateList(this)

            }
        })

    }
}
