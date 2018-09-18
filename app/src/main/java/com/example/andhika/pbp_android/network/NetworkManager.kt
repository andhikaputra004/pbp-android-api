package com.example.andhika.pbp_android.network

import com.example.andhika.pbp_android.model.GetListMakulResponse
import com.example.andhika.pbp_android.model.LoginRequest
import com.example.andhika.pbp_android.model.LoginResponse
import com.example.andhika.pbp_android.model.RegisterRequest
import com.example.andhika.pbp_android.model.RegisterResponse
import com.example.andhika.pbp_android.uisubscribe
import retrofit2.Response

class NetworkManager(private val networkAPI: NetworkAPI) {

    fun doLogin(request: LoginRequest, onNext: (Response<LoginResponse>) -> Unit,
                onError: (Throwable) -> Unit) = networkAPI
            .postLogin(request)
            .uisubscribe(onNext, onError)

    fun doRegister(request: RegisterRequest, onNext: (Response<RegisterResponse>) -> Unit,
                   onError: (Throwable) -> Unit) = networkAPI
            .postRegister(request)
            .uisubscribe(onNext, onError)
    fun doGetListMakul(onNext: (Response<GetListMakulResponse>) -> Unit,
                   onError: (Throwable) -> Unit) = networkAPI
            .getListMakul()
            .uisubscribe(onNext, onError)

}