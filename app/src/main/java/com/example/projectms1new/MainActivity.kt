package com.example.projectms1new

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val dataButton: Button = findViewById(R.id.button_data)
        dataButton.setOnClickListener {
            val intent = Intent(this, DataActivity::class.java)
            startActivity(intent)
        }

            val LogoutButton: Button = findViewById(R.id.button_logout)
            LogoutButton.setOnClickListener {
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)

        }
        val MapButton: Button = findViewById(R.id.button_map)
        MapButton.setOnClickListener {
            val intent = Intent(this, MapsssActivity::class.java)
            startActivity(intent)

        }
    }
}
