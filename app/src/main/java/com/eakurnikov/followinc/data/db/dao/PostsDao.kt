package com.eakurnikov.followinc.data.db.dao

import android.arch.persistence.room.*
import com.eakurnikov.followinc.data.db.entities.Post
import io.reactivex.Flowable

/**
 * Created by eakurnikov on 04.12.2018.
 */

@Dao
interface PostsDao {

    @Query("SELECT * FROM " + Post.TABLE_NAME)
    fun getAllPosts(): Flowable<List<Post>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(post: Post)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertList(posts: List<Post>)

//    @Query("DELETE FROM" + Post.TABLE_NAME + "WHERE id = :id")
//    fun deleteById(id: Int)
}