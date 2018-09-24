package com.example.andhika.pbp_android.network

import com.example.andhika.pbp_android.model.*
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT

interface NetworkAPI{

    @POST("user/login")
    fun postLogin(@Body loginRequest : LoginRequest) : Observable<Response<LoginResponse>>

    @POST("user/register")
    fun postRegister(@Body registerRequest : RegisterRequest) : Observable<Response<RegisterResponse>>

    @GET("makul/list")
    fun getListMakul() : Observable<Response<GetListMakulResponse>>

    @POST("makul/listbyId")
    fun getListById(@Body request: GetListRequest) : Observable<Response<ListIdMakul>>

    @POST("makul/insertmakul")
    fun insertMakul(@Body request: AddRequest) : Observable<Response<AddResponse>>

    @GET("makul/dosen")
    fun getListDosen() : Observable<Response<DosenResponse>>

    @PUT("makul/updatemakul")
    fun updateMakul(@Body requestEditDosenRequest: EditDosenRequest) : Observable<Response<EditDosenResponse>>

    @POST("makul/profile")
    fun postProfile(@Body request: ProfileRequest) : Observable<Response<ProfileResponse>>

    @PUT("user/update")
    fun updateUser(@Body requestEditDosenRequest: EditProfileRequest) : Observable<Response<AddResponse>>

    @POST("makul/event")
    fun getEvent(@Body reqEventRequest: GetEventRequest) : Observable<Response<GetEventResponse>>

    @POST("makul/addevent")
    fun addEvent(@Body request: AddEventRequest) : Observable<Response<AddResponse>>


}