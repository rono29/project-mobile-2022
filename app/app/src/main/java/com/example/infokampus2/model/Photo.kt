package com.example.infokampus2.model

import android.view.animation.Animation
import com.google.gson.annotations.SerializedName

//data class Photo(
//    @SerializedName("id")
//    val id: Int?,
//    @SerializedName("title")
//    val title: String?,
//    @SerializedName("thumbnailUrl")
//    val thumbnail: String?
//)

data class Photo(
    @SerializedName("desk")
    val desk: String?,
    @SerializedName("gambar")
    val thumbnail: String?,
    @SerializedName("Nama")
    val nama_univ: String?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("rating")
    val rating: String?
)

//data class
//Photo(
//    val desc: String,
//    val gambar: String,
//    val id: Int,
//    val nama_univ: String,
//    val rating: String
//)