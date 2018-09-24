package com.example.andhika.pbp_android.model

import com.google.gson.annotations.SerializedName


data class DosenResponse(
        @SerializedName("list_dosen") val listDosen: List<Dosen>
)

data class Dosen(
        @SerializedName("id_dosen") val idDosen: String?,
        @SerializedName("nama_dosen") val namaDosen: String?
)