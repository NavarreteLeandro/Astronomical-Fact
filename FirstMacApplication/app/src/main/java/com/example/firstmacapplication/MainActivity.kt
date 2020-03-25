package com.example.firstmacapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import com.example.firstmacapplication.viewModel.NasaViewModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nasaFragment = ImageNasaFragment()

        val fragmentManager : FragmentManager = supportFragmentManager

        fragmentManager.beginTransaction().add(R.id.nasa_image_container, nasaFragment).commit()

    }

}
