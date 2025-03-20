package com.natasa.catsanddogs

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.natasa.catsanddogs.databinding.ActivityDogImageBinding

class DogImageActivity : AppCompatActivity() {

    private val imageViewModel: ImagesViewModel by viewModels()
    private lateinit var binding: ActivityDogImageBinding
    private lateinit var dogImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDogImageBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        Log.d("Natasa dog url", "DOGACTIVITY")

        imageViewModel.getDogImage()

        imageViewModel.dogImage.observe(this) {
            Log.d("Natasa dog url", it)
            Glide.with(this).load(it).into(binding.dogImageIv)
        }

    }
}