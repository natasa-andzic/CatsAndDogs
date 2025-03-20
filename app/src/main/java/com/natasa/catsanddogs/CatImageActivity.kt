package com.natasa.catsanddogs

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.natasa.catsanddogs.databinding.ActivityCatImageBinding

class CatImageActivity : AppCompatActivity() {

    lateinit var activityCatImageBinding: ActivityCatImageBinding
    private val viewModel: ImagesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityCatImageBinding = ActivityCatImageBinding.inflate(layoutInflater)
        val view = activityCatImageBinding.root
        setContentView(view)
        viewModel.getCatImage()

        viewModel.image.observe(this) {
            Log.d("Natasa url", it)
            Glide.with(this)  // Use 'this' in Activity, 'context' in Fragment
                .load(it)  // Provide the image URL
                .placeholder(R.drawable.splash_screen)  // Optional placeholder image while loading
                .error(R.drawable.splash_screen)  // Optional error image in case of failure
                .into(activityCatImageBinding.catIv)
        }


    }
}