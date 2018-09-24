package com.example.andhika.pbp_android.section.Main.add

import com.example.andhika.pbp_android.base.BasePresenterInterface
import com.example.andhika.pbp_android.base.BaseViewInterface
import com.example.andhika.pbp_android.model.AddRequest
import com.example.andhika.pbp_android.model.AddResponse
import io.reactivex.Observable

interface AddContract {
    interface View : BaseViewInterface<Presenter> {
        fun showLoading()
        fun dismissLoading()
        fun goToMain(response: AddResponse)
        fun showError(any: Any)
    }

    interface Presenter : BasePresenterInterface<View> {
        fun insertMakul(request: AddRequest)
        fun setAddValidation(validation: Observable<Boolean>, onValid: (valid: Boolean) -> Unit = {})
    }
}