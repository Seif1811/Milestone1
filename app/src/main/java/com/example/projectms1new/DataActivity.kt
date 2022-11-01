package com.example.projectms1new

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class DataActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data)

        val SaveButton: Button = findViewById(R.id.button_save)
        SaveButton.setOnClickListener {
            savedata()

        }
        val DoneButton: Button = findViewById(R.id.button_Done)
        DoneButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        val DeleteButton: Button = findViewById(R.id.button_delete)
        DeleteButton.setOnClickListener {
            deletedata()
        }
    }

    private fun savedata() {
        val username: EditText = findViewById(R.id.username_text)
        val gender: EditText = findViewById(R.id.gender_text)
        val add: EditText = findViewById(R.id.add_text)
        if (username.text.isEmpty() || gender.text.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            return
        } else
        {
            val usernameinput = username.text.toString()
            val genderinput = gender.text.toString()
            val addinput = add.text.toString()
            val usernametext: TextView = findViewById(R.id.text_username)
            val gendertext: TextView= findViewById(R.id.text_gender)
            val addtext: TextView= findViewById(R.id.text_add)
            usernametext.text="Username:"+ usernameinput
            gendertext.text="Gender:" + genderinput
            addtext.text="Address:"+  addinput
        }
    }
    private fun deletedata() {
        val usernametext: TextView = findViewById(R.id.text_username)
        val gendertext: TextView= findViewById(R.id.text_gender)
        val addtext: TextView= findViewById(R.id.text_add)
        usernametext.text="Username:"
        gendertext.text="Gender:"
        addtext.text="Address:"

    }
}