package com.example.andhika.pbp_android.model
import com.google.gson.annotations.SerializedName



data class RegisterRequest(
    @SerializedName("nama_user") val namaUser: String?,
    @SerializedName("username") val username: String?,
    @SerializedName("password") val password: String?,
    @SerializedName("email") val email: String?
)