package com.example.tugasintegrasi

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tugasintegrasi.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val registeredUsername = intent.getStringExtra("username")
        val registeredPassword = intent.getStringExtra("password")
        val email = intent.getStringExtra("email")
        val phone = intent.getStringExtra("phone")
        val gender = intent.getStringExtra("gender")

        binding.btnLogin.setOnClickListener {
            val inputUsername = binding.etLoginUsername.text.toString()
            val inputPassword = binding.etLoginPassword.text.toString()

            if (inputUsername == registeredUsername && inputPassword == registeredPassword) {
                val intent = Intent(this, ProfileActivity::class.java)
                intent.putExtra("username", registeredUsername)
                intent.putExtra("email", email)
                intent.putExtra("phone", phone)
                intent.putExtra("gender", gender)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Username atau Password salah", Toast.LENGTH_SHORT).show()
            }
        }
    }

}