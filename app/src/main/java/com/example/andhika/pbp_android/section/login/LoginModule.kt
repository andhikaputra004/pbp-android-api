package com.example.andhika.pbp_android.section.login

import com.example.andhika.pbp_android.di.ActivityScoped
import dagger.Binds
import dagger.Module

@Module
abstract class LoginModule {
    @ActivityScoped
    @Binds
    abstract fun loginPresenter(loginPresenter: LoginPresenter): LoginContract.Presenter
}