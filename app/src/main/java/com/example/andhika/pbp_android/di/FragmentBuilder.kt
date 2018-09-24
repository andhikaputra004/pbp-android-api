package com.example.andhika.pbp_android.di

import com.example.andhika.pbp_android.section.Main.fragment.DosenFragment
import com.example.andhika.pbp_android.section.Main.fragment.MainFragment
import com.example.andhika.pbp_android.section.Main.fragment.ProfileFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilder {

    @FragmentScoped
    @ContributesAndroidInjector
    abstract fun bindMainFragment(): MainFragment

    @FragmentScoped
    @ContributesAndroidInjector
    abstract fun bindDosenFragment() : DosenFragment


    @FragmentScoped
    @ContributesAndroidInjector
    abstract fun bindProfile() : ProfileFragment
}

