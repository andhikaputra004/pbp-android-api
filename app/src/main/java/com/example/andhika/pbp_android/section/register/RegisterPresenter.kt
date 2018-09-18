package com.example.andhika.pbp_android.section.register

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.OnLifecycleEvent
import com.example.andhika.pbp_android.base.BasePresenter
import com.example.andhika.pbp_android.di.ActivityScoped
import com.example.andhika.pbp_android.model.RegisterRequest
import com.example.andhika.pbp_android.network.NetworkManager
import io.reactivex.Observable
import javax.inject.Inject

@ActivityScoped
class RegisterPresenter @Inject constructor(val networkManager: NetworkManager) : BasePresenter() , RegisterContract.Presenter{

    private var view : RegisterContract.View? = null

    override fun postRegister(request: RegisterRequest) {
        compositeDisposable.add(networkManager.doRegister(request, {
            when {
                it.isSuccessful -> {
                    view?.goToMain()
                }
            }
        }, {
            view?.showError(it)
        }))
    }

    override fun setRegisterValidation(validation: Observable<Boolean>, onValid: (valid: Boolean) -> Unit) {
        compositeDisposable.add(validation
                .subscribe {
                    onValid.invoke(it)
                })
    }

    override fun takeView(view: RegisterContract.View) {
        this.view = view
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    override fun dropView() {
        this.view = null
    }

}