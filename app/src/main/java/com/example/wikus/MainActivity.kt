package com.example.wikus

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //action button diklik
        button2.setOnClickListener{
            startActivity(Intent(this,Profil::class.java))
        }
        wisata.setOnClickListener{
            startActivity(Intent(this,WisataActivity::class.java))
        }
        kuliner.setOnClickListener{
            startActivity(Intent(this,KulinerActivity::class.java))
        }
        catatan.setOnClickListener{
            startActivity(Intent(this,CatatanActivity::class.java))
        }
    }
}