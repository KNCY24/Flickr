package com.e.flickr.ui.liste

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.e.flickr.R
import com.e.flickr.model.Photo

class MyAdapter(val photos : MutableLiveData<List<Photo>>, val callback: (Int) -> Unit) : RecyclerView.Adapter<MyAdapter.MyViewHolder>()  {

    class MyViewHolder(val v: LinearLayout) : RecyclerView.ViewHolder(v)
    // appelé quand le ViewHolder doit être créé (probablement parce que l'item devient visible)
    // on crée (inflate) le layout et on le place dans le ViewHolder

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.photo_layout ,parent,false)
        val holder = MyViewHolder(layout as LinearLayout)
        layout.setOnClickListener{
            callback(holder.adapterPosition)
        }
        return holder
    }
    // appelé quand le recycerview a besoin de connaître la taille de la liste qu'il doit afficher

    override fun getItemCount(): Int = photos.value!!.size
    // appelé quand on doit peupler le ViewHolder avec le contenu de l'élément numéro "position"

    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {
        val image = holder.v.findViewById<ImageView>(R.id.image)
        var photo = photos.value!!.get(position)
        val url = "https://farm" + photo.farm + ".staticflickr.com/" + photo.server + "/" + photo.id + "_" + photo.secret + ".jpg"
        Glide.with(image.context).load(url).into(image)




    }
}