package com.example.andhika.pbp_android.di

import android.annotation.SuppressLint
import com.example.andhika.pbp_android.section.Main.add.AddActivity
import com.example.andhika.pbp_android.section.Main.MainActivity
import com.example.andhika.pbp_android.section.Main.add_res.AddEventActivity
import com.example.andhika.pbp_android.section.Main.detail_makul.DetaimMakulActivity
import com.example.andhika.pbp_android.section.Main.detail_makul.EditDosenActivity
import com.example.andhika.pbp_android.section.Main.editprofile.EditProfileActivity
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

    @ActivityScoped
    @ContributesAndroidInjector
    abstract fun bindMainActivity() : MainActivity

    @ActivityScoped
    @ContributesAndroidInjector
    abstract fun bindDetailMakulActivity() : DetaimMakulActivity

    @ActivityScoped
    @ContributesAndroidInjector
    abstract fun bindAddActivity() : AddActivity


    @ActivityScoped
    @ContributesAndroidInjector
    abstract fun bindEditMakulActivity() : EditDosenActivity

    @ActivityScoped
    @ContributesAndroidInjector
    abstract fun bindEditProfile() : EditProfileActivity


    @ActivityScoped
    @ContributesAndroidInjector
    abstract fun bindAddEvent() : AddEventActivity
}