package com.natasa.catsanddogs

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.natasa.catsanddogs.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.catsBtn.setOnClickListener {
            val intent = Intent(this, HerokuCatFactActivity::class.java)
            startActivity(intent)
        }

        binding.dogsBtn.setOnClickListener {
            val intent = Intent(this, KinduffDogFactActivity::class.java)
            startActivity(intent)
        }

        binding.catsImageBtn.setOnClickListener {
            val intent = Intent(this, CatImageActivity::class.java)
            startActivity(intent)
        }

        binding.dogsImageBtn.setOnClickListener {
            val intent = Intent(this, DogImageActivity::class.java)
            startActivity(intent)
        }


    }
}