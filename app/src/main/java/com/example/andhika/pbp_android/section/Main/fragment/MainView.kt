package com.example.andhika.pbp_android.section.Main.fragment

import com.example.andhika.pbp_android.model.Makul

interface MainView {
    fun showLoading()
    fun dismissLoading()
    fun goToMain(response: List<Makul>)
    fun showError(any: Any)
    fun setPresenter(presenter: MainFragmentPresenter)
    fun loadMainFragment()

}