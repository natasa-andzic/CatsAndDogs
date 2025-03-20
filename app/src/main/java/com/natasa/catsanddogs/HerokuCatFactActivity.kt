package com.natasa.catsanddogs

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class HerokuCatFactActivity : AppCompatActivity() {

    private val viewModel: HerokuCatViewModel by viewModels()
    private lateinit var text: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_heroku_cat_fact)

        viewModel.getCatFact()

        text = findViewById(R.id.herokuCatTv)

        viewModel.fact.observe(this) {
            text.text = it.toString()
        }

    }
}