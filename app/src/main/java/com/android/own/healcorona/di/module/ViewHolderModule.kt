package com.android.own.healcorona.di.module

import androidx.lifecycle.LifecycleRegistry
import com.android.own.healcorona.di.ViewModelScope
import com.android.own.healcorona.ui.base.BaseItemViewHolder
import dagger.Module
import dagger.Provides

@Module
class ViewHolderModule(private val viewHolder: BaseItemViewHolder<*, *>) {

    @Provides
    @ViewModelScope
    fun provideLifecycleRegistry(): LifecycleRegistry = LifecycleRegistry(viewHolder)
}