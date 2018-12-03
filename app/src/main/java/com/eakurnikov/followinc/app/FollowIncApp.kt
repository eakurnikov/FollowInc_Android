package com.eakurnikov.followinc.app

import com.eakurnikov.followinc.di.components.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

/**
 * Created by eakurnikov on 04.12.2018.
 */

class FollowIncApp: DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out FollowIncApp> {
        return DaggerApplicationComponent.builder().create(this)
    }
}