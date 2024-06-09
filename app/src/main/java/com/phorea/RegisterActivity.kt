package com.phorea

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class RegisterActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val nameEdit: EditText = findViewById(R.id.nameEdit)
        val idEdit: EditText = findViewById(R.id.idEdit)
        val pwEdit: EditText = findViewById(R.id.pwEdit)
        val nicknameEdit: EditText = findViewById(R.id.nicknameEdit)
        val saveBtn: Button = findViewById(R.id.btn_save)

        saveBtn.setOnClickListener {
            auth = FirebaseAuth.getInstance()

            val nName = nameEdit.text.toString()
            val nId = idEdit.text.toString()
            val nNickname = nicknameEdit.text.toString()
            val nPw = pwEdit.text.toString()

            auth.createUserWithEmailAndPassword(nId, nPw)
                .addOnCompleteListener(this) { task ->
                    if (nPw.length < 6) {
                        Toast.makeText(this, "Please set the password to at least 6 digits", Toast.LENGTH_SHORT).show()
                    }
                    if (task.isSuccessful) {
                        val user = auth.currentUser
                        if (user != null) {
                            Toast.makeText(this, "Register Success", Toast.LENGTH_SHORT).show()
                            saveUserInfo(user.uid, nId, nName, nNickname)
                        }
                    } else {
                        Toast.makeText(this, "Retry Register", Toast.LENGTH_SHORT).show()
                    }
                }
        }
    }

    private fun saveUserInfo(userId: String, id: String, name: String, nickname: String) {
        val user = hashMapOf(
            "id" to id,
            "name" to name,
            "nickname" to nickname
        )

        db.collection("users").document(userId).set(user)
            .addOnSuccessListener {
                Toast.makeText(this, "Save User", Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener {
                Toast.makeText(this, "No Save User", Toast.LENGTH_SHORT).show()
            }
        finish()
    }
}
