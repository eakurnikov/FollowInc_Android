package com.eakurnikov.followinc.di.modules

import com.eakurnikov.followinc.di.annotations.ActivityScope
import com.eakurnikov.followinc.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Contains all activities to be bound to application dependency graph
 *
 * Created by eakurnikov on 04.12.2018.
 */

@Module
interface ActivityBuilderModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    fun bindsMainActivity(): MainActivity
}