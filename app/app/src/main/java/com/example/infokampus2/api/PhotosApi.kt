package com.example.infokampus2.api

import io.reactivex.Single
import com.example.infokampus2.model.Photo
import retrofit2.http.GET

interface PhotosApi {
    @GET("data")
    fun getPhotos(): Single<List<Photo>>
}
