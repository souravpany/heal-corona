package com.android.own.healcorona.ui.precautions.adapter

import android.view.ViewGroup
import androidx.lifecycle.Lifecycle
import com.android.own.healcorona.data.model.PrecautionsData
import com.android.own.healcorona.ui.base.BaseAdapter
import com.android.own.healcorona.ui.precautions.adapter.PrecautionItemViewHolder

class PrecautionListAdapter(
    parentLifecycle: Lifecycle,
    precaution: ArrayList<PrecautionsData>
) : BaseAdapter<PrecautionsData, PrecautionItemViewHolder>(parentLifecycle, precaution) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        PrecautionItemViewHolder(parent)
}