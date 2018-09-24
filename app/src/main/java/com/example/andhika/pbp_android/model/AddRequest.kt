package com.example.andhika.pbp_android.model
import com.google.gson.annotations.SerializedName



data class AddRequest(
    @SerializedName("nama_makul") val namaMakul: String?,
    @SerializedName("nama_dosen") val namaDosen: String?,
    @SerializedName("lokasi_makul") val lokasiMakul: String?
)