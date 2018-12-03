package com.eakurnikov.followinc.vm.base

import android.arch.lifecycle.ViewModel

/**
 * Created by eakurnikov on 04.12.2018.
 */

abstract class BaseVm : ViewModel() {

    abstract fun onStart()

    abstract fun onStop()

    protected abstract fun subscribe()

    protected abstract fun dispose()
}