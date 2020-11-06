package com.e.flickr.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.e.flickr.model.Photo
import com.e.flickr.model.Photos
import com.e.flickr.model.SearchResult
import com.e.flickr.repository.FlickrAPI
import com.e.flickr.repository.Repository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class MainViewModel : ViewModel() {

    var position = 0
    val repository = Repository()
    val mldPhoto = MutableLiveData<Photo>()
    val mldPhotos = MutableLiveData<Photos>()

    val callback = object:Callback<SearchResult>{
        override fun onFailure(call: Call<SearchResult>, t: Throwable) {
            print("Erreur callback")
        }

        override fun onResponse(call: Call<SearchResult>, response: Response<SearchResult>) {
            var reponse: SearchResult? = response.body()
            if (reponse != null) {
                mldPhoto.value= reponse.photos.photo.get(0)
            }
        }
    }

    init {
        repository.getPhotos(callback)
    }

    fun nextPhoto() {
        position =+1
        if(position == mldPhotos.value?.photo?.size !!){
            position = 0
        }
        mldPhoto.value=  mldPhotos.value?.photo?.get(position)
    }
}