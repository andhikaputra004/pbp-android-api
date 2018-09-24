package com.example.andhika.pbp_android.model
import com.google.gson.annotations.SerializedName



data class GetEventRequest(
    @SerializedName("id_detil_event") val idDetilEvent: Int?
)