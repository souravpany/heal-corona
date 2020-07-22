package com.android.own.healcorona.ui.global.adapter

import android.view.ViewGroup
import androidx.lifecycle.Lifecycle
import com.android.own.healcorona.data.model.Countries
import com.android.own.healcorona.ui.base.BaseAdapter
import com.android.own.healcorona.ui.global.adapter.GlobalDataItemViewHolder

class GlobalDataListAdapter(
    parentLifecycle: Lifecycle,
    countries: ArrayList<Countries>
) : BaseAdapter<Countries, GlobalDataItemViewHolder>(parentLifecycle, countries) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        GlobalDataItemViewHolder(parent)

}