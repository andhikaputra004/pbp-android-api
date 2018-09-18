package com.example.andhika.pbp_android.section.Main.fragment

import com.example.andhika.pbp_android.base.BasePresenter
import com.example.andhika.pbp_android.network.NetworkManager

class MainFragmentPresenter(val networkManager: NetworkManager, val view: MainView) : BasePresenter() {

    init {
        view.setPresenter(this)
    }

    fun getConfirmation() {
        view.showLoading()
        compositeDisposable.add(networkManager.doGetListMakul({ response ->
            view.dismissLoading()
            when {
                response.isSuccessful -> {
                    response.body()?.let {
                        view.goToMain(it.listMakul)
                    }
                }
            }
        }, {
            view.dismissLoading()
            view.showError(it)
        }))
    }

}