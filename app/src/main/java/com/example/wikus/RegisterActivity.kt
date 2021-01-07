package com.example.wikus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    lateinit var handler: Database

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        //action button diklik
        btnLogRegister.setOnClickListener {
            onBackPressed()
        }

        //memanggil db
        handler = Database(this)

        //action button diklik
        button.setOnClickListener {
            //pengecekan inputan dan melakukan insert db
            if (nama.text.toString() == "" || username.text.toString() == ""|| password.text.toString() == "") {
                Toast.makeText(this, "Semua Data Wajib Diisi!", Toast.LENGTH_SHORT).show()
            } else {
                if (handler.insertUserData(nama.text.toString(), username.text.toString(), password.text.toString())) {
                    Toast.makeText(this, "Pendaftaran Anda Telah Sukses!", Toast.LENGTH_SHORT).show()
                    nama.text?.clear()
                    username.text?.clear()
                    password.text?.clear()
                    onBackPressed()
                } else {
                    Toast.makeText(this, "Username yang Anda Masukkan Tidak Tersedia!", Toast.LENGTH_SHORT)
                        .show()
                    password.text?.clear()
                }
            }
        }
    }

    //fungsi button
    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.slide_from_left,R.anim.slide_to_right)
    }
}