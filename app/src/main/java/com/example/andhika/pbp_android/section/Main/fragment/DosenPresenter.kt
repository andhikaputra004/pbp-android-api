package com.example.andhika.pbp_android.section.Main.fragment

import com.example.andhika.pbp_android.base.BasePresenter
import com.example.andhika.pbp_android.network.NetworkManager

class DosenPresenter(val networkManager: NetworkManager, val view : DosenView) : BasePresenter(){

    init {
        view.setPresenter(this)
    }
    fun getListDosen(){
        compositeDisposable.add(networkManager.doGetDosen({response ->
            when{
                response.isSuccessful->{
                    response.body()?.let {
                        view.goToMain(it)
                    }
                }
            }
        },{
            it.printStackTrace()
        }))
    }
}