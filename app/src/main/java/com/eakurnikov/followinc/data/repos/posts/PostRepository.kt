package com.eakurnikov.followinc.data.repos.posts

import com.eakurnikov.followinc.data.db.entities.Post
import com.eakurnikov.followinc.data.Resource
import com.eakurnikov.followinc.data.network.models.PostDto
import com.eakurnikov.followinc.data.repos.Repository
import io.reactivex.subjects.BehaviorSubject

/**
 * Created by eakurnikov on 04.12.2018.
 */

abstract class PostRepository: Repository<PostDto, Post>() {

    protected abstract var cachedPosts: List<Post>

    abstract val postsSubject: BehaviorSubject<Resource<List<Post>>>

    abstract fun getPosts()
}