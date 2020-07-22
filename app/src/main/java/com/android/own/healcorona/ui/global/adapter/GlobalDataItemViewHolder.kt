package com.android.own.healcorona.ui.global.adapter

import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.android.own.healcorona.R
import com.android.own.healcorona.data.model.Countries
import com.android.own.healcorona.di.component.ViewHolderComponent
import com.android.own.healcorona.ui.base.BaseItemViewHolder
import kotlinx.android.synthetic.main.row_country.view.*

class GlobalDataItemViewHolder(
    parent: ViewGroup
) :
    BaseItemViewHolder<Countries, GlobalDataItemViewModel>(R.layout.row_country, parent) {


    override fun injectDependencies(viewHolderComponent: ViewHolderComponent) {
        viewHolderComponent.inject(this)
    }

    override fun setupObservers() {
        super.setupObservers()

        viewModel.countryCode.observe(this, Observer {
            itemView.ivFlag.text = it
        })

        viewModel.countryName.observe(this, Observer {
            itemView.tvCountryName.text = it
        })

        viewModel.totalConfirmed.observe(this, Observer {
            itemView.tvTotalCases.text = it
        })

        viewModel.totalRecovered.observe(this, Observer {
            itemView.tvRecovered.text = it
        })

        viewModel.newConfirmed.observe(this, Observer {
            itemView.tvTodayCases.text = it
        })

        viewModel.totalDeaths.observe(this, Observer {
            itemView.tvDeaths.text = it
        })


    }

    override fun setupView(view: View) {

    }
}