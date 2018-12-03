package com.eakurnikov.followinc.di.modules

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.eakurnikov.followinc.di.annotations.ViewModelKey
import com.eakurnikov.followinc.vm.MainVm
import com.eakurnikov.followinc.vm.base.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Provides map of all ViewModels and a ViewModelFactory for dependencies
 *
 * Created by eakurnikov on 04.12.2018.
 */

@Module
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainVm::class)
    fun bindsMainViewModel(mainVm: MainVm): ViewModel

    @Binds
    fun bindsViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory
}