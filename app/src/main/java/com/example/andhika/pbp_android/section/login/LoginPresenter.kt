package com.example.andhika.pbp_android.section.login

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.OnLifecycleEvent
import com.example.andhika.pbp_android.base.BasePresenter
import com.example.andhika.pbp_android.di.ActivityScoped
import com.example.andhika.pbp_android.model.LoginRequest
import com.example.andhika.pbp_android.network.NetworkManager
import io.reactivex.Observable
import javax.inject.Inject


@ActivityScoped
class LoginPresenter @Inject constructor(val networkManager: NetworkManager) : BasePresenter(), LoginContract.Presenter {

    private var view: LoginContract.View? = null

    override fun takeView(view: LoginContract.View) {
        this.view = view
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    override fun dropView() {
        this.view = null
    }

    override fun postLogin(request: LoginRequest) {
        compositeDisposable.add(networkManager.doLogin(request, {
            when {
                it.isSuccessful -> {
                    view?.goToMain()
                }
            }
        }, {
            view?.showError(it)
        }))
    }

    override fun setLoginValidation(validation: Observable<Boolean>, onValid: (valid: Boolean) -> Unit) {
        compositeDisposable.add(validation
                .subscribe {
                    onValid.invoke(it)
                })
    }

}