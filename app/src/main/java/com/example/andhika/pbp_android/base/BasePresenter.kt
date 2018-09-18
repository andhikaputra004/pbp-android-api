package com.example.andhika.pbp_android.base

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import io.reactivex.disposables.CompositeDisposable

abstract class BasePresenter : LifecycleObserver {
    protected val compositeDisposable = CompositeDisposable()

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun clearCompositeDisposable() {
        compositeDisposable.clear()
    }
}