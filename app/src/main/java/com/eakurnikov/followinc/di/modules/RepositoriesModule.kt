package com.eakurnikov.followinc.di.modules

import com.eakurnikov.followinc.di.annotations.ApplicationScope
import com.eakurnikov.followinc.data.repos.posts.PostRepository
import com.eakurnikov.followinc.data.repos.posts.PostsRepositoryImpl
import dagger.Binds
import dagger.Module

/**
 * Contains all repositories
 *
 * Created by eakurnikov on 04.12.2018.
 */

@Module(includes = [DatabaseModule::class, ApiModule::class])
interface RepositoriesModule {

    @Binds
    @ApplicationScope
    fun bindsPostRepository(impl: PostsRepositoryImpl): PostRepository
}