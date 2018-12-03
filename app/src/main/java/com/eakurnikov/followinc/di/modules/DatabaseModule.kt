package com.eakurnikov.followinc.di.modules

import android.arch.persistence.room.Room
import android.content.Context
import com.eakurnikov.followinc.data.db.FollowIncDatabase
import com.eakurnikov.followinc.di.annotations.ApplicationScope
import com.eakurnikov.followinc.utils.DATABASE_NAME
import dagger.Module
import dagger.Provides

/**
 * Contains database
 *
 * Created by eakurnikov on 04.12.2018.
 */

@Module
class DatabaseModule {

    @Provides
    @ApplicationScope
    fun provideFollowIncDatabase(context: Context): FollowIncDatabase {
        return Room.databaseBuilder(context, FollowIncDatabase::class.java, DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }
}