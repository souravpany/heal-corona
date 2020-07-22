package com.android.own.healcorona.ui.symptoms.adapter

import android.view.ViewGroup
import androidx.lifecycle.Lifecycle
import com.android.own.healcorona.data.model.SymptomsData
import com.android.own.healcorona.ui.base.BaseAdapter
import com.android.own.healcorona.ui.symptoms.adapter.SymptomsItemViewHolder

class SymptomsListAdapter(
    parentLifecycle: Lifecycle,
    symptoms: ArrayList<SymptomsData>
) : BaseAdapter<SymptomsData, SymptomsItemViewHolder>(parentLifecycle, symptoms) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        SymptomsItemViewHolder(parent)
}