package com.example.andhika.pbp_android.section.Main.add

import android.util.Log
import com.example.andhika.pbp_android.base.BasePresenter
import com.example.andhika.pbp_android.di.ActivityScoped
import com.example.andhika.pbp_android.model.AddRequest
import com.example.andhika.pbp_android.network.NetworkManager
import io.reactivex.Observable
import javax.inject.Inject

@ActivityScoped
class AddPresenter @Inject constructor(val networkManager: NetworkManager) : BasePresenter(), AddContract.Presenter {

    var view: AddContract.View? = null

    override fun insertMakul(request: AddRequest) {
        compositeDisposable.add(networkManager.doInsertMakul(request, { response ->
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

    override fun takeView(view: AddContract.View) {
        this.view = view
    }

    override fun dropView() {
        this.view = null
    }

    override fun setAddValidation(validation: Observable<Boolean>, onValid: (valid: Boolean) -> Unit) {
        compositeDisposable.add(validation.subscribe {
            onValid.invoke(it)
        })
    }

}