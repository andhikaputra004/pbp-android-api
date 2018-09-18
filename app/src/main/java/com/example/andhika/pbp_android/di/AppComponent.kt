package com.example.andhika.pbp_android.di

import android.app.Application
import com.example.andhika.pbp_android.PBPApp
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AndroidSupportInjectionModule::class, NetworkModule::class, ActivityBuilder::class))
interface AppComponent : AndroidInjector<DaggerApplication> {
    fun inject(pbpApp: PBPApp)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun networkModule(networkModule: NetworkModule): Builder
        fun build(): AppComponent
    }
}
