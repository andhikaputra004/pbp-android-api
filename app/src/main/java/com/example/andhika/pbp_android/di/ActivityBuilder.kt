package com.example.andhika.pbp_android.di

import android.annotation.SuppressLint
import com.example.andhika.pbp_android.section.login.LoginActivity
import com.example.andhika.pbp_android.section.login.LoginModule
import com.example.andhika.pbp_android.section.register.RegisterActivity
import com.example.andhika.pbp_android.section.register.RegisterModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@SuppressLint("unused")
@Module
abstract class ActivityBuilder {

    @ActivityScoped
    @ContributesAndroidInjector(modules = arrayOf(LoginModule::class))
    abstract fun bindLoginActivity(): LoginActivity

    @ActivityScoped
    @ContributesAndroidInjector(modules = arrayOf(RegisterModule::class))
    abstract fun bindRegisterActivity() : RegisterActivity

}