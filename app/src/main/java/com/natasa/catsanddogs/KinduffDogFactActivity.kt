package com.natasa.catsanddogs

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class KinduffDogFactActivity : AppCompatActivity() {

    private val kinduffDogViewModel: KinduffDogViewModel by viewModels()

    lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kinduff_dog_fact)

        textView = findViewById(R.id.dogFactTv)

        kinduffDogViewModel.getDogFact()

        kinduffDogViewModel.fact.observe(this) { it->
            Log.d("Natasa", it)
            textView.text = it?:""
        }

    }
}