package com.example.andhika.pbp_android.model
import com.google.gson.annotations.SerializedName



data class GetEventResponse(
    @SerializedName("event") val message: List<Event>
)

data class Event(
    @SerializedName("id_event") val idEvent: String?,
    @SerializedName("nama_event") val namaEvent: String?,
    @SerializedName("tgl_event") val tglEvent: String?,
    @SerializedName("id_detil_event") val idDetilEvent: String?,
    @SerializedName("nama_detil_event") val detil_nama : String?
)