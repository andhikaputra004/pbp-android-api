package com.example.andhika.pbp_android.model

import com.google.gson.annotations.SerializedName


data class LoginResponse(
        @SerializedName("success") val success: Boolean?,
        @SerializedName("message") val message: String?,
        @SerializedName("datapelanggan") val datapelanggan: Datapelanggan?
)

data class Datapelanggan(
        @SerializedName("id_user") val idUser: Int?,
        @SerializedName("nama_user") val namaUser: String?,
        @SerializedName("username") val username: String?,
        @SerializedName("password") val password: String?,
        @SerializedName("email") val email: String?
)