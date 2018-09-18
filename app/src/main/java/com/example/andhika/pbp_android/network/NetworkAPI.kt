package com.example.andhika.pbp_android.network

import com.example.andhika.pbp_android.model.GetListMakulResponse
import com.example.andhika.pbp_android.model.LoginRequest
import com.example.andhika.pbp_android.model.LoginResponse
import com.example.andhika.pbp_android.model.RegisterRequest
import com.example.andhika.pbp_android.model.RegisterResponse
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface NetworkAPI{

    @POST("user/login")
    fun postLogin(@Body loginRequest : LoginRequest) : Observable<Response<LoginResponse>>

    @POST("user/register")
    fun postRegister(@Body registerRequest : RegisterRequest) : Observable<Response<RegisterResponse>>

    @GET("makul/list")
    fun getListMakul() : Observable<Response<GetListMakulResponse>>
}