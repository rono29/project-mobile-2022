package com.example.infokampus2.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.infokampus2.api.PhotoService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import com.example.infokampus2.model.Photo

class ListViewModel : ViewModel() {
    private val photoService = PhotoService()
    private val disposable = CompositeDisposable()
    val data = MutableLiveData<List<Photo>>()

    fun fetchData() {
        disposable.add(
            photoService.getPhotos()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<List<Photo>>() {
                    override fun onSuccess(value: List<Photo>?) {
                        data.value = value
                    }

                    override fun onError(e: Throwable?) {
                        Log.e("ERRORFETCHDATA", "error$e")
                    }
                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}
