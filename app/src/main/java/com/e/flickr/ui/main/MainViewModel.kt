package com.e.flickr.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.e.flickr.model.Photo
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
    val mlPhoto = mutableListOf<SearchResult>()
    val lPhoto = mlPhoto.get(0).photos?.photo
    val callback = object:Callback<SearchResult>{
        override fun onFailure(call: Call<SearchResult>, t: Throwable) {
            print("Erreur callback")
        }

        override fun onResponse(call: Call<SearchResult>, response: Response<SearchResult>) {
            var reponse = response.body()
            if (reponse !=null && lPhoto != null) {
                mlPhoto.add(reponse)
                mldPhoto.value = lPhoto.get(position)
            }
        }
    }

    init {
        repository.getPhotos(callback)
    }

    fun nextPhoto() {
        position =+1
        if (lPhoto != null) {
            mldPhoto.value = lPhoto.get(position)
        }
    }
}