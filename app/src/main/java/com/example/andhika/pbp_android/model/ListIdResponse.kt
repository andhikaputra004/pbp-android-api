package com.example.andhika.pbp_android.model
import com.google.gson.annotations.SerializedName



data class ListIdMakul(
    @SerializedName("message") val message: List<Message?>?
)

data class Message(
    @SerializedName("id_makul") val idMakul: Int?,
    @SerializedName("nama_makul") val namaMakul: String?,
    @SerializedName("nama_dosen") val namaDosen: String?,
    @SerializedName("lokasi_makul") val lokasiMakul: String?,
    @SerializedName("id_event") val idEvent: String?
)