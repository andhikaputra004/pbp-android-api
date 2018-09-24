package com.example.andhika.pbp_android.section.Main

import com.example.andhika.pbp_android.base.BasePresenter
import com.example.andhika.pbp_android.di.ActivityScoped
import com.example.andhika.pbp_android.network.NetworkManager
import javax.inject.Inject

@ActivityScoped
class MainPresenter @Inject constructor(val networkManager: NetworkManager) : BasePresenter(), MainContract.Presenter {
    private var view: MainContract.View? = null
    override fun getListMakul() {
        compositeDisposable.add(networkManager.doGetListMakul({
            when {
                it.isSuccessful -> {
                    it.body()?.let { list ->
                        view?.goToMain(list)
                    }
                }
            }
        }, {
            view?.showError(it)
        }))
    }

    override fun takeView(view: MainContract.View) {
        this.view = view
    }

    override fun dropView() {
        this.view = null
    }

}