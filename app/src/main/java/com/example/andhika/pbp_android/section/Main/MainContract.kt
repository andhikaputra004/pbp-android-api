package com.example.andhika.pbp_android.section.Main

import com.example.andhika.pbp_android.base.BasePresenterInterface
import com.example.andhika.pbp_android.base.BaseViewInterface
import com.example.andhika.pbp_android.model.GetListMakulResponse

interface MainContract {
    interface View : BaseViewInterface<Presenter> {
        fun showLoading()
        fun dismissLoading()
        fun goToMain(response: GetListMakulResponse)
        fun showError(any: Any)
    }

    interface Presenter : BasePresenterInterface<View> {
        fun getListMakul()
    }
}