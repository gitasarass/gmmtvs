package com.example.gmmtv

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val dataKey = intent.getStringExtra("data_key")
        if (dataKey != null) {
            val tvDataName: TextView = findViewById(R.id.nameTextView)
            tvDataName.text = getString(R.string.name_profile)
            val tvDataEmail: TextView = findViewById(R.id.emailTextView)
            tvDataEmail.text = getString(R.string.email_profile)
            val ivDataPhoto: ImageView = findViewById(R.id.avatarImageView)
            ivDataPhoto.setImageResource(R.drawable.gita)
        } else {
            Toast.makeText(this, "Data tidak ditemukan", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}