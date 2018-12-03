package com.eakurnikov.followinc.data.db.entities

import android.arch.persistence.room.Entity
import android.arch.persistence.room.Index
import android.arch.persistence.room.PrimaryKey
import com.eakurnikov.followinc.data.db.entities.Post.Companion.TABLE_NAME

/**
 * Created by eakurnikov on 04.12.2018.
 */

@Entity(
    tableName = TABLE_NAME,
    indices = [Index("id", unique = true)]
)
class Post {

    companion object {
        const val TABLE_NAME = "Post"
    }

    @PrimaryKey(autoGenerate = true)
    var dbId: Long? = null

    var userId: Int? = null
    var id: Int? = null
    var title: String? = null
    var body: String? = null
}