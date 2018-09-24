package com.example.andhika.pbp_android.model
import com.google.gson.annotations.SerializedName



data class ProfileRequest(
    @SerializedName("username") val username: String?
)