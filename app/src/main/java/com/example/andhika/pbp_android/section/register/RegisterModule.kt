package com.example.andhika.pbp_android.section.register

import com.example.andhika.pbp_android.di.ActivityScoped
import dagger.Binds
import dagger.Module

@Module
abstract class RegisterModule {
    @ActivityScoped
    @Binds
    abstract fun registerPresenter(registerPresenter: RegisterPresenter): RegisterContract.Presenter
}