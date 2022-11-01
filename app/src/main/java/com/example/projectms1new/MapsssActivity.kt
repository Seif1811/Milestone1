package com.example.projectms1new

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MapsssActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mapsss)
        val BackButton: Button = findViewById(R.id.button_back2)
        BackButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        val LocationButton: Button = findViewById(R.id.button_maps)
        LocationButton.setOnClickListener {
            val intent = Intent(this, NewMapActivity::class.java)
            startActivity(intent)
        }
    }
}