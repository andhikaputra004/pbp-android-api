package com.example.andhika.pbp_android.section.login

import com.example.andhika.pbp_android.base.BasePresenterInterface
import com.example.andhika.pbp_android.base.BaseViewInterface
import com.example.andhika.pbp_android.model.LoginRequest
import io.reactivex.Observable

interface LoginContract {
    interface View : BaseViewInterface<Presenter> {
        fun showLoading()
        fun dismissLoading()
        fun goToMain()
        fun showError(any: Any)
    }

    interface Presenter : BasePresenterInterface<View> {
        fun postLogin(request: LoginRequest)
        fun setLoginValidation(validation: Observable<Boolean>, onValid: (valid: Boolean) -> Unit = {})
    }
}