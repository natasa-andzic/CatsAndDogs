package com.natasa.catsanddogs

import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val intent = Intent(this, MainActivity::class.java)

        val splashImage: ImageView = findViewById(R.id.imageView)
        val fadeOut = ObjectAnimator.ofFloat(splashImage, "alpha", 1f, 0f)
        fadeOut.duration = 5000
        fadeOut.start()

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(intent)
            finish()
        }, 5000)
    }
}