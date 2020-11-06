package com.e.flickr.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.e.flickr.R
import com.e.flickr.model.Photo
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    private lateinit var imageview : ImageView
    private lateinit var btnNEXT :Button
    private lateinit var btnALL :Button

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        var view = inflater.inflate(R.layout.main_fragment, container, false)
        imageview = view.findViewById(R.id.imageView)
        btnNEXT = view.findViewById(R.id.buttonNEXT)
        btnALL = view.findViewById(R.id.buttonALL)

        btnNEXT.setOnClickListener(View.OnClickListener {
            viewModel.nextPhoto()
        })
        btnALL.setOnClickListener(View.OnClickListener {
            Navigation.findNavController(btnALL).navigate(R.id.action_mainF_to_listF);
        })
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        viewModel = MainViewModel()
        viewModel.mldPhoto.observe(requireActivity(), Observer<Photo> { photo: Photo ->
            val url = "https://farm" + photo.farm + ".staticflickr.com/" + photo.server + "/" + photo.id + "_" + photo.secret + ".jpg"
            Glide.with(requireActivity()).load(url).into(imageview)
            imageview.setOnClickListener(View.OnClickListener{
                val action = MainFragmentDirections.actionMainFToFullF(url)
                findNavController().navigate(action)
            })
        })
    }

}