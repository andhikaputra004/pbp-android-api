package com.example.andhika.pbp_android.model
import com.google.gson.annotations.SerializedName



data class AddEventRequest(
    @SerializedName("nama_event") val namaEvent: String?,
    @SerializedName("id_detil_event") val idDetilEvent: Int?,
    @SerializedName("tgl_event") val tgl_event : String?,
    @SerializedName("nama_detil_event") val namaDetilEvent: String?
)