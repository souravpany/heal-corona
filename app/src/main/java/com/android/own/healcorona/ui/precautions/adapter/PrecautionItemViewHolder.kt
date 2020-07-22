package com.android.own.healcorona.ui.precautions.adapter

import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.android.own.healcorona.R
import com.android.own.healcorona.data.model.PrecautionsData
import com.android.own.healcorona.di.component.ViewHolderComponent
import com.android.own.healcorona.ui.base.BaseItemViewHolder
import kotlinx.android.synthetic.main.row_precaution_item.view.*

class PrecautionItemViewHolder(
    parent: ViewGroup
) :
    BaseItemViewHolder<PrecautionsData, PrecautionItemViewModel>(R.layout.row_precaution_item, parent) {

    override fun injectDependencies(viewHolderComponent: ViewHolderComponent) {
        viewHolderComponent.inject(this)
    }

    override fun setupObservers() {
        super.setupObservers()

        viewModel.precautionName.observe(this, Observer {
            itemView.tvPrecautionName.text = it
        })

        viewModel.precautionImage.observe(this, Observer {
            it?.run {

                itemView.ivPrecaution.setImageResource(it)

            }
        })

    }

    override fun setupView(view: View) {

    }
}