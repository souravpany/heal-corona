package com.android.own.healcorona.ui.main.dashboardactivity.adapter

import android.view.ViewGroup
import androidx.lifecycle.Lifecycle
import com.android.own.healcorona.data.model.DashboardMenu
import com.android.own.healcorona.ui.base.BaseAdapter
import com.android.own.healcorona.ui.main.dashboardactivity.adapter.DBItemViewHolder

class DBMenuListAdapter(
    parentLifecycle: Lifecycle,
    trending: ArrayList<DashboardMenu>
) : BaseAdapter<DashboardMenu, DBItemViewHolder>(parentLifecycle, trending) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DBItemViewHolder(parent)
}