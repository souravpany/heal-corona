package com.android.own.healcorona.ui.main.dashboardactivity.adapter

import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.android.own.healcorona.R
import com.android.own.healcorona.data.model.DashboardMenu
import com.android.own.healcorona.di.component.ViewHolderComponent
import com.android.own.healcorona.ui.base.BaseItemViewHolder
import kotlinx.android.synthetic.main.row_dashboard.view.*

class DBItemViewHolder(
    parent: ViewGroup
) :
    BaseItemViewHolder<DashboardMenu, DBItemViewModel>(R.layout.row_dashboard, parent) {

    override fun injectDependencies(viewHolderComponent: ViewHolderComponent) {
        viewHolderComponent.inject(this)
    }

    override fun setupObservers() {
        super.setupObservers()

        viewModel.menuName.observe(this, Observer {
            itemView.tvMenu.text = it
        })

        viewModel.menuImage.observe(this, Observer {
            it?.run {

                itemView.ivMenu.setImageResource(it)

            }
        })

    }

    override fun setupView(view: View) {

    }
}