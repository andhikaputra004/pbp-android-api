package com.example.andhika.pbp_android.section.Main.editprofile

import com.example.andhika.pbp_android.base.BasePresenterInterface
import com.example.andhika.pbp_android.base.BaseViewInterface
import com.example.andhika.pbp_android.model.AddResponse
import com.example.andhika.pbp_android.model.EditProfileRequest


interface EditProfileContract {
    interface View : BaseViewInterface<Presenter> {
        fun showLoading()
        fun dismissLoading()
        fun goToMain(response: AddResponse)
        fun showError(any: Any)
    }

    interface Presenter : BasePresenterInterface<View> {
        fun postUpdateUser(request: EditProfileRequest)
    }
}