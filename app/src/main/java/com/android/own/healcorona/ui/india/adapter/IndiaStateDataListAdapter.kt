package com.android.own.healcorona.ui.india.adapter

import android.view.ViewGroup
import androidx.lifecycle.Lifecycle
import com.android.own.healcorona.data.model.StateWiseData
import com.android.own.healcorona.ui.base.BaseAdapter
import com.android.own.healcorona.ui.india.adapter.IndiaStateDataItemViewHolder

class IndiaStateDataListAdapter(
    parentLifecycle: Lifecycle,
    stateWiseData: ArrayList<StateWiseData>
) : BaseAdapter<StateWiseData, IndiaStateDataItemViewHolder>(parentLifecycle, stateWiseData) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        IndiaStateDataItemViewHolder(parent)

}