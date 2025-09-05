package com.projectzoo

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.projectzoo.auth.login.LoginActivity
import com.projectzoo.databinding.ActivitySplashScreenBinding

class SplashScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Animasi logo
        val zoomIn = AnimationUtils.loadAnimation(this, R.anim.zoom_in)
        binding.logoImage.startAnimation(zoomIn)

        // Delay sebelum animasi teks
        Handler(mainLooper).postDelayed({
            binding.appName.visibility = android.view.View.VISIBLE
            val fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in)
            binding.appName.startAnimation(fadeIn)
        }, 1000)

        // Pindah ke MainActivity setelah 3 detik
        Handler(mainLooper).postDelayed({
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }, 3000)
    }
}
