package com.eakurnikov.followinc.di.modules

import com.eakurnikov.followinc.data.network.api.PostApi
import com.eakurnikov.followinc.di.annotations.ApplicationScope
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

/**
 * Contains all apis
 *
 * Created by eakurnikov on 04.12.2018.
 */

@Module(includes = [NetworkModule::class])
class ApiModule {

    @Provides
    @ApplicationScope
    fun providePostApi(retrofit: Retrofit): PostApi {
        return retrofit.create(PostApi::class.java)
    }
}