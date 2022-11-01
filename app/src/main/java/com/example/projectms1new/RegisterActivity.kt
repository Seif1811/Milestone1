package com.example.projectms1new

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class RegisterActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        // Initialize Firebase Auth
        auth = Firebase.auth

        val loginText: TextView = findViewById(R.id.textView_login_now)
        loginText.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        val registerButton: Button = findViewById(R.id.button_register)
        registerButton.setOnClickListener {

            performSignup()
        }
    }
        private fun performSignup() {
            val email = findViewById<EditText>(R.id.editText_email_register)
            val password = findViewById<EditText>(R.id.editTextTextPassword_register)

            if (email.text.isEmpty() || password.text.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT)
            }

                val inputEmail = email.text.toString()
                val inputPassword = password.text.toString()
                auth.createUserWithEmailAndPassword(inputEmail, inputPassword)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            // Sign in success, update UI with the signed-in user's information
                            val intent = Intent(this, MainActivity::class.java)
                            startActivity(intent)

                            Toast.makeText(
                                baseContext, "Authentication Successful.",
                                Toast.LENGTH_SHORT
                            ).show()

                        } else {
                            // If sign in fails, display a message to the user.

                            Toast.makeText(
                                baseContext, "Authentication failed.",
                                Toast.LENGTH_SHORT
                            ).show()

                        }
                    }
                    .addOnFailureListener {
                        Toast.makeText(
                            this,
                            "Error Occurred ${it.localizedMessage}",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

            }
        }






