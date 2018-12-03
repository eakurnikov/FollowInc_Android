package com.eakurnikov.followinc.di.modules

import android.content.Context
import com.eakurnikov.followinc.app.FollowIncApp
import com.eakurnikov.followinc.di.annotations.ApplicationScope
import dagger.Binds
import dagger.Module

/**
 * Application level dependencies
 *
 * Created by eakurnikov on 04.12.2018.
 */

@Module
interface ApplicationModule {

    @Binds
    @ApplicationScope
    fun bindsContext(app: FollowIncApp): Context
}