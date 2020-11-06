package com.e.flickr.ui.full

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.e.flickr.R

class FullFragment : Fragment() {

    companion object {
        fun newInstance() = FullFragment()
    }

    private lateinit var viewModel : FullViewModel
    private lateinit var imageview : ImageView

    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?,savedInstanceState: Bundle?): View? {
        var view=inflater.inflate(R.layout.full_fragment,container,false)
        imageview = view.findViewById<ImageView>(R.id.imageView2)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val url = FullFragmentArgs.fromBundle(arguments!!).url
        Glide.with(requireActivity()).load(url).into(imageview)
    }

}

