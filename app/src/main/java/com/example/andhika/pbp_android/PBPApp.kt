package com.example.andhika.pbp_android

import com.example.andhika.pbp_android.di.DaggerAppComponent
import com.example.andhika.pbp_android.di.NetworkModule
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication


class PBPApp : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication>? {
        val appComponent = DaggerAppComponent
                .builder()
                .application(this)
                .networkModule(NetworkModule())
                .build()
        appComponent.inject(this)
        return appComponent
    }


}