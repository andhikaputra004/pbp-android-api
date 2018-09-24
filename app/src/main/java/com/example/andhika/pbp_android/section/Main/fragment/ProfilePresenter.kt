package com.example.andhika.pbp_android.section.Main.fragment

import com.example.andhika.pbp_android.base.BasePresenter
import com.example.andhika.pbp_android.model.LoginRequest
import com.example.andhika.pbp_android.model.ProfileRequest
import com.example.andhika.pbp_android.network.NetworkManager

class ProfilePresenter(val networkManager: NetworkManager,val view: ProfileView) : BasePresenter(){

    init {
        view.setPresenter(this)
    }

    fun profileRequest(request: ProfileRequest){
        compositeDisposable.add(networkManager.doProfile(request,{
            when{
                it.isSuccessful->{
                    it.body()?.let {
                        view.goToMain(it)
                    }
                }
            }
        },{
            view.showError(it)
        }))
    }


}