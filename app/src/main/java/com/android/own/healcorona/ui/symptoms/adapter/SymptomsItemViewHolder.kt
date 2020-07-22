package com.android.own.healcorona.ui.symptoms.adapter

import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.android.own.healcorona.R
import com.android.own.healcorona.data.model.SymptomsData
import com.android.own.healcorona.di.component.ViewHolderComponent
import com.android.own.healcorona.ui.base.BaseItemViewHolder
import kotlinx.android.synthetic.main.row_precaution_item.view.*


class SymptomsItemViewHolder(
    parent: ViewGroup
) :
    BaseItemViewHolder<SymptomsData, SymptomsItemViewModel>(R.layout.row_precaution_item, parent) {

    override fun injectDependencies(viewHolderComponent: ViewHolderComponent) {
        viewHolderComponent.inject(this)
    }

    override fun setupObservers() {
        super.setupObservers()

        viewModel.symptomsName.observe(this, Observer {
            itemView.tvPrecautionName.text = it
        })

        viewModel.symptomsImage.observe(this, Observer {
            it?.run {

                itemView.ivPrecaution.setImageResource(it)

            }
        })

    }

    override fun setupView(view: View) {

    }
}