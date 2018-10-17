package com.example.andhika.pbp_android.section.register

import com.example.andhika.pbp_android.base.BasePresenterInterface
import com.example.andhika.pbp_android.base.BaseViewInterface
import com.example.andhika.pbp_android.model.RegisterRequest
import com.example.andhika.pbp_android.model.RegisterResponse
import io.reactivex.Observable

interface RegisterContract {
    interface View : BaseViewInterface<Presenter> {
        fun showLoading()
        fun dismissLoading()
        fun goToMain(response : RegisterResponse)
        fun showError(any: Any)
    }

    interface Presenter : BasePresenterInterface<View> {
        fun postRegister(request: RegisterRequest)
        fun setRegisterValidation(validation: Observable<Boolean>, onValid: (valid: Boolean) -> Unit = {})
    }
}