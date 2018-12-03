package com.eakurnikov.followinc.vm

import com.eakurnikov.followinc.data.db.entities.Post
import com.eakurnikov.followinc.data.repos.posts.PostRepository
import com.eakurnikov.followinc.data.Resource
import com.eakurnikov.followinc.vm.base.BaseVm
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.subjects.BehaviorSubject
import javax.inject.Inject

/**
 * Created by eakurnikov on 04.12.2018.
 */

class MainVm @Inject constructor(private val postRepo: PostRepository) : BaseVm() {

    var postsSubject = BehaviorSubject.createDefault<Resource<List<Post>>>(Resource.loading(null))

    private var disposables = CompositeDisposable()

    private val onPosts = object: DisposableObserver<Resource<List<Post>>>() {
        override fun onComplete() {
        }

        override fun onNext(t: Resource<List<Post>>) {
            postsSubject.onNext(t)
        }

        override fun onError(e: Throwable) {
        }
    }

    override fun onStart() {
        subscribe()
    }

    override fun onStop() {
        dispose()
    }

    override fun subscribe() {
        disposables.add(
            postRepo.postsSubject
                .subscribeWith(onPosts)
        )
    }

    override fun dispose() {
        disposables.dispose()
    }

    fun getPosts() {
        postRepo.getPosts()
    }
}