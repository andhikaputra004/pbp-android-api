package com.example.andhika.pbp_android.section.Main.add_res

import com.example.andhika.pbp_android.base.BasePresenterInterface
import com.example.andhika.pbp_android.base.BaseViewInterface
import com.example.andhika.pbp_android.model.AddEventRequest
import com.example.andhika.pbp_android.model.AddResponse
import io.reactivex.Observable


interface AddEventContract {
    interface View : BaseViewInterface<Presenter> {
        fun showLoading()
        fun dismissLoading()
        fun goToMain(response: AddResponse)
        fun showError(any: Any)
    }

    interface Presenter : BasePresenterInterface<View> {
        fun insertEvent(request: AddEventRequest)
        fun setAddValidation(validation: Observable<Boolean>, onValid: (valid: Boolean) -> Unit = {})

    }
}