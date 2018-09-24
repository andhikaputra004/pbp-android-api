package com.example.andhika.pbp_android.section.Main.fragment

import com.example.andhika.pbp_android.model.DosenResponse
import com.example.andhika.pbp_android.model.Makul


interface DosenView {
    fun showLoading()
    fun dismissLoading()
    fun goToMain(response: DosenResponse)
    fun showError(any: Any)
    fun setPresenter(presenter: DosenPresenter)
    fun loadMainFragment()

}