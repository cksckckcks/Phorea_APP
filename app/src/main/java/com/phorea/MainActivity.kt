package com.phorea

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val loginBtn: TextView = findViewById(R.id.btn_getText)
        val idTextBox: TextView = findViewById(R.id.ID_TextBox)
        val pwTextBox: TextView = findViewById(R.id.PW_TextBox)
        val registerText: TextView = findViewById(R.id.RegesterText)

        loginBtn.setOnClickListener {
            auth = FirebaseAuth.getInstance()
            val idText = idTextBox.text.toString()
            val pwText = pwTextBox.text.toString()

            auth.signInWithEmailAndPassword(idText, pwText)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        val mapIntent: Intent = Intent(this, MapActivity::class.java)
                        startActivity(mapIntent)
                    } else {
                        Toast.makeText(this, "check your id pw", Toast.LENGTH_LONG).show()
                    }
                }
        }

        registerText.setOnClickListener {
            val intent: Intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}
