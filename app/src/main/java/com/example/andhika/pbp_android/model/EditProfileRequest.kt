package com.example.andhika.pbp_android.model
import com.google.gson.annotations.SerializedName



data class EditProfileRequest(
    @SerializedName("id_user") val idUser: Int?,
    @SerializedName("username") val username: String?,
    @SerializedName("email") val email: String?
)