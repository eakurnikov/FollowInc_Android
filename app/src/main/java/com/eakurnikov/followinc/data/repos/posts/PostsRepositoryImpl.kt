package com.eakurnikov.followinc.data.repos.posts

import com.eakurnikov.followinc.data.db.entities.Post
import com.eakurnikov.followinc.data.network.services.PostApiService
import com.eakurnikov.followinc.data.Resource
import com.eakurnikov.followinc.data.db.FollowIncDatabase
import com.eakurnikov.followinc.data.network.models.PostDto
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.BehaviorSubject
import javax.inject.Inject

/**
 * Created by eakurnikov on 04.12.2018.
 */

class PostsRepositoryImpl @Inject constructor(
    private val db: FollowIncDatabase,
    private val postApiService: PostApiService
): PostRepository() {

    private var postsRequestDisposable: Disposable? = null

    override var cachedPosts = emptyList<Post>()

    override val postsSubject =
        BehaviorSubject.createDefault<Resource<List<Post>>>(Resource.loading(null))


    override fun getPosts() {
        if (cachedPosts.isNotEmpty()) {
            postsSubject.onNext(
                Resource.success(cachedPosts)
            )
        } else {
            postsSubject.onNext(
                Resource.loading(null)
            )
        }

        postsRequestDisposable = postApiService.getPosts()
            .subscribeOn(Schedulers.io())
            .subscribe({ postDtos ->
                val postEntities = postDtos.map { getEntityByDto(it) }

                cachedPosts = postEntities

                postsSubject.onNext(
                    Resource.success(postEntities)
                )

                postsRequestDisposable?.dispose()
                postsRequestDisposable = null
            }, { error ->
                postsSubject.onNext(
                    Resource.error(
                        error.message!!,
                        cachedPosts
                    )
                )

                postsRequestDisposable?.dispose()
                postsRequestDisposable = null
            })
    }

    override fun getEntityByDto(dto: PostDto): Post {
        val entity = Post()

        entity.userId = dto.userId
        entity.id = dto.id
        entity.title = dto.title
        entity.body = dto.body

        return entity
    }
}