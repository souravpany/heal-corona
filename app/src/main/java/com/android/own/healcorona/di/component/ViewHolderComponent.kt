package com.android.own.healcorona.di.component


import com.android.own.healcorona.di.ViewModelScope
import com.android.own.healcorona.di.module.ViewHolderModule
import com.android.own.healcorona.ui.global.adapter.GlobalDataItemViewHolder
import com.android.own.healcorona.ui.india.adapter.IndiaStateDataItemViewHolder
import com.android.own.healcorona.ui.main.dashboardactivity.adapter.DBItemViewHolder
import com.android.own.healcorona.ui.precautions.adapter.PrecautionItemViewHolder
import com.android.own.healcorona.ui.symptoms.adapter.SymptomsItemViewHolder
import dagger.Component

@ViewModelScope
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [ViewHolderModule::class]
)
interface ViewHolderComponent {


    fun inject(viewHolder: DBItemViewHolder)

    fun inject(viewHolder: PrecautionItemViewHolder)

    fun inject(viewHolder: SymptomsItemViewHolder)

    fun inject(viewHolder: IndiaStateDataItemViewHolder)

    fun inject(viewHolder: GlobalDataItemViewHolder)


}