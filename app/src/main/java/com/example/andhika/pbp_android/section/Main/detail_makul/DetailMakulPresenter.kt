package com.example.andhika.pbp_android.section.Main.detail_makul

import com.example.andhika.pbp_android.base.BasePresenter
import com.example.andhika.pbp_android.di.ActivityScoped
import com.example.andhika.pbp_android.model.GetEventRequest
import com.example.andhika.pbp_android.model.GetListRequest
import com.example.andhika.pbp_android.network.NetworkManager
import javax.inject.Inject

@ActivityScoped
class DetailMakulPresenter @Inject constructor(val networkManager: NetworkManager) : BasePresenter(), DetailMakulContract.Presenter {

    var view: DetailMakulContract.View? = null
    override fun getListMakul(request: GetListRequest) {
        compositeDisposable.add(networkManager.doGetListMakulbyId(request, { response ->
            when {
                response.isSuccessful -> {
                    response.body()?.let {
                        view?.goToMain(it)
                    }
                }
            }
        }, {
            it.printStackTrace()
        }))
    }

    override fun getEvent(request: GetEventRequest) {
        compositeDisposable.add(networkManager.dogetEvent(request,{
            when{
                it.isSuccessful->{
                    it.body()?.let {
                        view?.getEvent(it)
                    }
                }
            }
        },{

        }))
    }
    override fun takeView(view: DetailMakulContract.View) {
        this.view = view
    }

    override fun dropView() {
        this.view = null
    }

}