package com.example.firstmacapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.example.firstmacapplication.viewModel.NasaViewModel

class ImageNasaFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var data : NasaViewModel = NasaViewModel()

        var rootView: View = inflater.inflate(R.layout.nasa_image_fragment, container, false)

        var imageView : ImageView = rootView.findViewById(R.id.image_nasa)

        NasaViewModel.DownlandImageTask(imageView).execute(data.returnHdUrl())

        return rootView
    }

}