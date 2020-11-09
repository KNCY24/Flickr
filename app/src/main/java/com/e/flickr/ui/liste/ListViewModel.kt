package com.e.flickr.ui.liste

import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.e.flickr.model.Photo
import com.e.flickr.model.SearchResult
import com.e.flickr.repository.Repository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListViewModel : ViewModel() {

    var position = 0
    val repository = Repository()
    val mldPhoto = MutableLiveData<List<Photo>>()

    val callback = object: Callback<SearchResult> {
        override fun onFailure(call: Call<SearchResult>, t: Throwable) {
            print("Erreur callback")
        }

        override fun onResponse(call: Call<SearchResult>, response: Response<SearchResult>) {
            var reponse: SearchResult? = response.body()
            if (response.isSuccessful) {
                mldPhoto.value=  response.body()?.photos?.photo
            }
        }
    }

    init {
        repository.getPhotos(callback)
    }
}