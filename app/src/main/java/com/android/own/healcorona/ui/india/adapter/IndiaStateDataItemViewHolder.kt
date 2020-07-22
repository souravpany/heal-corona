package com.android.own.healcorona.ui.india.adapter

import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.android.own.healcorona.R
import com.android.own.healcorona.data.model.StateWiseData
import com.android.own.healcorona.di.component.ViewHolderComponent
import com.android.own.healcorona.ui.base.BaseItemViewHolder
import kotlinx.android.synthetic.main.row_state_data.view.*

class IndiaStateDataItemViewHolder(
    parent: ViewGroup
) :
    BaseItemViewHolder<StateWiseData, IndiaStateDataItemViewModel>(
        R.layout.row_state_data,
        parent
    ) {

    override fun injectDependencies(viewHolderComponent: ViewHolderComponent) {
        viewHolderComponent.inject(this)
    }

    override fun setupObservers() {
        super.setupObservers()

        viewModel.stateCode.observe(this, Observer {
            itemView.ivFlag.text = it
        })

        viewModel.stateName.observe(this, Observer {
            itemView.tvStateName.text = it
        })

        viewModel.confirmed.observe(this, Observer {
            itemView.tvTotalCases.text = it
        })

        viewModel.active.observe(this, Observer {
            itemView.tvTodayCases.text = it
        })

        viewModel.recovered.observe(this, Observer {
            itemView.tvRecovered.text = it
        })

        viewModel.deaths.observe(this, Observer {
            itemView.tvDeaths.text = it
        })

    }

    override fun setupView(view: View) {

    }
}