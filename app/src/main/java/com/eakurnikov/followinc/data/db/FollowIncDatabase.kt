package com.eakurnikov.followinc.data.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.eakurnikov.followinc.data.db.dao.PostsDao
import com.eakurnikov.followinc.data.db.entities.Post

/**
 * Created by eakurnikov on 04.12.2018.
 */

@Database(
    entities = [Post::class],
    version = 1,
    exportSchema = false
)
//@TypeConverters(FollowIncTypeConverters::class)
abstract class FollowIncDatabase : RoomDatabase() {

    abstract fun postsDao(): PostsDao
}