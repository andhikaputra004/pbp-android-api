package com.example.andhika.pbp_android.di

import com.example.andhika.pbp_android.section.Main.fragment.MainFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilder {

    @FragmentScoped
    @ContributesAndroidInjector
    abstract fun bindMainFragment(): MainFragment

}

