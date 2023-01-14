package com.example.infokampus2.api

import io.reactivex.Single
import com.example.infokampus2.model.Photo
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class PhotoService {
    private val BASE_URL = "https://retoolapi.dev/Qno6dY/"
    private val api: PhotosApi

    init {
        api = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(PhotosApi::class.java)
    }

    fun getPhotos(): Single<List<Photo>> {
        return api.getPhotos()
    }
}
