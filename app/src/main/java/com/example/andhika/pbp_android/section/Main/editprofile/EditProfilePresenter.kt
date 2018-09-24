package com.example.andhika.pbp_android.section.Main.editprofile

import com.example.andhika.pbp_android.base.BasePresenter
import com.example.andhika.pbp_android.di.ActivityScoped
import com.example.andhika.pbp_android.model.EditProfileRequest
import com.example.andhika.pbp_android.network.NetworkManager
import javax.inject.Inject

@ActivityScoped
class EditProfilePresenter @Inject constructor(val networkManager: NetworkManager) : BasePresenter() , EditProfileContract.Presenter{
    var view : EditProfileContract.View? = null
    override fun postUpdateUser(request: EditProfileRequest) {
        compositeDisposable.add(networkManager.doUpdateProfule(request,{
            when{
                it.isSuccessful->{
                    it.body()?.let {
                        view?.goToMain(it)
                    }
                }
            }
        },{
            view?.showError(it)
        }))
    }

    override fun takeView(view: EditProfileContract.View) {
        this.view = view
    }

    override fun dropView() {
        this.view = null
    }

}