package com.example.wikus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar

class Profil : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profil)
        //mengatur action bar
        val aksi : ActionBar?=supportActionBar
        aksi!!.setDisplayHomeAsUpEnabled(true)
        aksi!!.setDisplayShowHomeEnabled(true)
        val nama = "Profil Mahasiswa"
        aksi.setTitle(nama)
    }
}