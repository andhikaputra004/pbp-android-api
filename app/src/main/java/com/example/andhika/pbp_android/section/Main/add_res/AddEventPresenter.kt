package com.example.andhika.pbp_android.section.Main.add_res

import com.example.andhika.pbp_android.base.BasePresenter
import com.example.andhika.pbp_android.di.ActivityScoped
import com.example.andhika.pbp_android.model.AddEventRequest
import com.example.andhika.pbp_android.network.NetworkManager
import io.reactivex.Observable
import javax.inject.Inject

@ActivityScoped
class AddEventPresenter @Inject constructor(val networkManager: NetworkManager) : BasePresenter(),AddEventContract.Presenter{
    var view : AddEventContract.View? = null

    override fun insertEvent(request: AddEventRequest) {
        compositeDisposable.add(networkManager.doAddEvent(request,{
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

    override fun setAddValidation(validation: Observable<Boolean>, onValid: (valid: Boolean) -> Unit) {
        compositeDisposable.add(validation.subscribe {
            onValid.invoke(it)
        })
    }

    override fun takeView(view: AddEventContract.View) {
        this.view = view
    }

    override fun dropView() {
        this.view = null
    }

}