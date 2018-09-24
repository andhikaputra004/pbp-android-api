package com.example.andhika.pbp_android.section.Main.detail_makul

import android.widget.Toast
import com.example.andhika.pbp_android.base.BasePresenter
import com.example.andhika.pbp_android.di.ActivityScoped
import com.example.andhika.pbp_android.model.EditDosenRequest
import com.example.andhika.pbp_android.model.GetListRequest
import com.example.andhika.pbp_android.network.NetworkManager
import javax.inject.Inject

@ActivityScoped
class EditDosenPresenter @Inject constructor(val networkManager: NetworkManager) : BasePresenter() , EditDosenContract.Presenter{
    var view : EditDosenContract.View? = null
    override fun getListMakul(request: EditDosenRequest) {
        compositeDisposable.add(networkManager.doUpdateDosen(request,{
            when{
                it.isSuccessful ->{
                    it.body()?.let {
                        view?.goToMain(it)
                    }
                }
            }
        },{
            view?.showError(it)
        }))
    }

    override fun takeView(view: EditDosenContract.View) {
        this.view = view
    }

    override fun dropView() {
        this.view = null
    }

}