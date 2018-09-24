package com.example.andhika.pbp_android.model
import com.google.gson.annotations.SerializedName



data class GetListMakulResponse(
    @SerializedName("list_makul") val listMakul: MutableList<Makul>
)

data class Makul(
    @SerializedName("id_makul") val idMakul: Int?,
    @SerializedName("nama_makul") val namaMakul: String?,
    @SerializedName("nama_dosen") val namaDosen: String?,
    @SerializedName("lokasi_makul") val lokasiMakul: String?,
    @SerializedName("nama_event") val namaEvent: String?
)