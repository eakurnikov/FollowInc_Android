package com.eakurnikov.followinc.ui

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.widget.Toast
import com.eakurnikov.followinc.R
import com.eakurnikov.followinc.data.Resource
import com.eakurnikov.followinc.data.db.entities.Post
import com.eakurnikov.followinc.vm.MainVm
import dagger.android.support.DaggerAppCompatActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

/**
 * Created by eakurnikov on 04.12.2018.
 */

class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var mainVm: MainVm

    private var disposables = CompositeDisposable()

    private val onPosts = object : DisposableObserver<Resource<List<Post>>>() {
        override fun onComplete() {
        }

        override fun onNext(resource: Resource<List<Post>>) {
            when (resource.status) {
                Resource.Status.SUCCESS -> {
                    val posts = resource.data?.toString()
                    tv.text = posts
                }
                Resource.Status.LOADING -> {
                    tv.text = "Loading..."
                }
                Resource.Status.ERROR -> {
                    tv.text = "ERROR :("
                }
            }
        }

        override fun onError(e: Throwable) {
            Toast.makeText(this@MainActivity, e.message, Toast.LENGTH_LONG).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainVm = ViewModelProviders.of(this, viewModelFactory).get(MainVm::class.java)
    }

    override fun onStart() {
        super.onStart()
        mainVm.onStart()

        disposables.add(
            mainVm.postsSubject
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(onPosts)
        )

        btn.setOnClickListener { mainVm.getPosts() }
    }

    override fun onStop() {
        super.onStop()
        mainVm.onStop()

        disposables.dispose()
    }
}