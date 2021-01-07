package com.example.wikus

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    lateinit var handler: Database

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //memanggil db
        handler = Database(this)

        //action button diklik
        btnRegLogin.setOnClickListener {
            startActivity(Intent(this,RegisterActivity::class.java))
            overridePendingTransition(R.anim.slide_from_right,R.anim.slide_to_left)
        }

        //action button diklik
        button.setOnClickListener {
            //pengecekan inputan sesuai dengan data db
            if (username.text.toString() == "" || password.text.toString() == "") {
                Toast.makeText(this, "Harap Mengisi Username dan Password!", Toast.LENGTH_SHORT).show()
            }else {
                if (handler.userPresent(username.text.toString(), password.text.toString())) {
                    Toast.makeText(this, "Login Berhasil!", Toast.LENGTH_SHORT).show()
                    username.text?.clear()
                    password.text?.clear()
                    val intentMain = Intent(this, MainActivity::class.java)
                    startActivity(intentMain)
                } else {
                    Toast.makeText(this, "Username atau Password yang Anda Masukkan Salah!", Toast.LENGTH_SHORT)
                        .show()
                    username.text?.clear()
                    password.text?.clear()
                }
            }
        }
    }
}