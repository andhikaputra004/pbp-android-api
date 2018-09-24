package com.example.andhika.pbp_android.section.Main.fragment

import com.example.andhika.pbp_android.model.ProfileRequest
import com.example.andhika.pbp_android.model.ProfileResponse


interface ProfileView {
    fun showLoading()
    fun dismissLoading()
    fun goToMain(response: ProfileResponse)
    fun showError(any: Any)
    fun setPresenter(presenter: ProfilePresenter)
    fun loadMainFragment()
}