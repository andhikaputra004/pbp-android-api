package com.example.andhika.pbp_android.model
import com.google.gson.annotations.SerializedName



data class EditDosenRequest(
    @SerializedName("id_makul") val idMakul: Int?,
    @SerializedName("nama_makul") val namaMakul: String?,
    @SerializedName("lokasi_makul") val lokasiMakul: String?
)