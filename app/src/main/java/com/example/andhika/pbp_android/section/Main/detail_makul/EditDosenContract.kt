package com.example.andhika.pbp_android.section.Main.detail_makul

import com.example.andhika.pbp_android.base.BasePresenterInterface
import com.example.andhika.pbp_android.base.BaseViewInterface
import com.example.andhika.pbp_android.model.EditDosenRequest
import com.example.andhika.pbp_android.model.EditDosenResponse
import com.example.andhika.pbp_android.model.GetListRequest
import com.example.andhika.pbp_android.model.ListIdMakul


interface EditDosenContract {
    interface View : BaseViewInterface<Presenter> {
        fun showLoading()
        fun dismissLoading()
        fun goToMain(response: EditDosenResponse)
        fun showError(any: Any)
    }

    interface Presenter : BasePresenterInterface<View> {
        fun getListMakul(request: EditDosenRequest)
    }
}