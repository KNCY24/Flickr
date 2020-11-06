package com.e.flickr.ui.liste

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.e.flickr.R
import com.e.flickr.model.Photo

class ListFragment : Fragment(){

    companion object {
        fun newInstance() = ListFragment()
    }
    private lateinit var viewModel: ListViewModel
    private lateinit var recyclerV : RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        var view = inflater.inflate(R.layout.main_fragment, container, false)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ListViewModel()
        viewModel.mldPhoto.observe(requireActivity(), Observer<List<Photo>> {
            recyclerV = view!!.findViewById<RecyclerView>(R.id.recyclerviewlist)
            recyclerV.layoutManager = GridLayoutManager(requireContext(),2)
            val adapter = MyAdapter(viewModel.mldPhoto, {position ->
                var photo = viewModel.mldPhoto.value!!.get(position)
                val url = "https://farm" + photo.farm + ".staticflickr.com/" + photo.server + "/" + photo.id + "_" + photo.secret + ".jpg"
                val action = ListFragmentDirections.actionListFToFullF(url)
                findNavController().navigate(action)
            })
            recyclerV.adapter = adapter
        })
    }
}