package com.example.andhika.pbp_android.section.Main.detail_makul

import com.example.andhika.pbp_android.base.BasePresenterInterface
import com.example.andhika.pbp_android.base.BaseViewInterface
import com.example.andhika.pbp_android.model.GetEventRequest
import com.example.andhika.pbp_android.model.GetEventResponse
import com.example.andhika.pbp_android.model.GetListMakulResponse
import com.example.andhika.pbp_android.model.GetListRequest
import com.example.andhika.pbp_android.model.ListIdMakul
import com.example.andhika.pbp_android.model.Makul

interface DetailMakulContract {
    interface View : BaseViewInterface<Presenter> {
        fun showLoading()
        fun dismissLoading()
        fun goToMain(response: ListIdMakul)
        fun showError(any: Any)
        fun getEvent(response:GetEventResponse)
    }

    interface Presenter : BasePresenterInterface<View> {
        fun getListMakul(request: GetListRequest)
        fun getEvent(request: GetEventRequest)
    }
}