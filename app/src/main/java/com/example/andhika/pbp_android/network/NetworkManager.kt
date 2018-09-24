package com.example.andhika.pbp_android.network

import com.example.andhika.pbp_android.model.*
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


    fun doGetListMakulbyId(request: GetListRequest,onNext: (Response<ListIdMakul>) -> Unit,
                       onError: (Throwable) -> Unit) = networkAPI
            .getListById(request)
            .uisubscribe(onNext, onError)
    fun doInsertMakul(request: AddRequest,onNext: (Response<AddResponse>) -> Unit,
                           onError: (Throwable) -> Unit) = networkAPI
            .insertMakul(request)
            .uisubscribe(onNext, onError)
    fun doGetDosen(onNext: (Response<DosenResponse>) -> Unit,
                      onError: (Throwable) -> Unit) = networkAPI
            .getListDosen()
            .uisubscribe(onNext, onError)
    fun doUpdateDosen(request:EditDosenRequest,onNext: (Response<EditDosenResponse>) -> Unit,
                   onError: (Throwable) -> Unit) = networkAPI
            .updateMakul(request)
            .uisubscribe(onNext, onError)
    fun doProfile(request:ProfileRequest,onNext: (Response<ProfileResponse>) -> Unit,
                      onError: (Throwable) -> Unit) = networkAPI
            .postProfile(request)
            .uisubscribe(onNext, onError)

    fun doUpdateProfule(request:EditProfileRequest,onNext: (Response<AddResponse>) -> Unit,
                      onError: (Throwable) -> Unit) = networkAPI
            .updateUser(request)
            .uisubscribe(onNext, onError)


    fun dogetEvent(request:GetEventRequest,onNext: (Response<GetEventResponse>) -> Unit,
                        onError: (Throwable) -> Unit) = networkAPI
            .getEvent(request)
            .uisubscribe(onNext, onError)


    fun doAddEvent(request:AddEventRequest,onNext: (Response<AddResponse>) -> Unit,
                   onError: (Throwable) -> Unit) = networkAPI
            .addEvent(request)
            .uisubscribe(onNext, onError)

}