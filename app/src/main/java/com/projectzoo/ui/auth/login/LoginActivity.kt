package com.projectzoo.ui.auth.login

import android.content.Intent
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.*
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.projectzoo.R
import com.projectzoo.ui.menu.MainMenuActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val logo = findViewById<ImageView>(R.id.logo)
        val etUsername = findViewById<EditText>(R.id.etUsername)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val tvForgotPassword = findViewById<TextView>(R.id.tvForgotPassword)
        val tvSignup = findViewById<TextView>(R.id.tvSignup)
        val tvSignupLink = findViewById<TextView>(R.id.tvSignupLink)
        val imgDino = findViewById<ImageView>(R.id.imgDino)

        val slideAnim = AnimationUtils.loadAnimation(this, R.anim.slide_fade_in)

        logo.startAnimation(slideAnim)

        etUsername.startAnimation(slideAnim.apply { startOffset = 200 })
        etPassword.startAnimation(slideAnim.apply { startOffset = 400 })
        tvForgotPassword.startAnimation(slideAnim.apply { startOffset = 600 })
        btnLogin.startAnimation(slideAnim.apply { startOffset = 800 })
        tvSignup.startAnimation(slideAnim.apply { startOffset = 1000 })
        tvSignupLink.startAnimation(slideAnim.apply { startOffset = 1200 })
        imgDino.startAnimation(slideAnim.apply { startOffset = 1400 })

        btnLogin.setOnClickListener {
            val username = etUsername.text.toString().trim()
            val password = etPassword.text.toString().trim()

            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Username dan Password tidak boleh kosong", Toast.LENGTH_SHORT).show()
            } else {
                if (username == "admin" && password == "1234") {
                    Toast.makeText(this, "Login Berhasil 🎉", Toast.LENGTH_SHORT).show()

                    // Pindah ke MainMenuActivity
                    val intent = Intent(this, MainMenuActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    Toast.makeText(this, "Username atau Password salah", Toast.LENGTH_SHORT).show()
                }
            }
        }

        tvForgotPassword.setOnClickListener {
            Toast.makeText(this, "Fitur lupa password belum tersedia", Toast.LENGTH_SHORT).show()
        }

        tvSignupLink.setOnClickListener {
            Toast.makeText(this, "Arahkan ke halaman Sign-up", Toast.LENGTH_SHORT).show()
        }
    }
}
