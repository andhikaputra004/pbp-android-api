package com.example.andhika.pbp_android.model
import com.google.gson.annotations.SerializedName



data class ProfileResponse(
    @SerializedName("data_user") val dataUser: DataUser?
)
