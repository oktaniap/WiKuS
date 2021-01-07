package com.example.wikus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import kotlinx.android.synthetic.main.activity_wisata__view_.*

class Wisata_View_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wisata__view_)
        //mengatur action bar
        val aksi : ActionBar?=supportActionBar
        aksi!!.setDisplayHomeAsUpEnabled(true)
        aksi!!.setDisplayShowHomeEnabled(true)

        //mengambil data intent
        var intent = intent
        val nama = intent.getStringExtra("nama")
        val deskripsi = intent.getStringExtra("deskripsi")
        val gambar = intent.getIntExtra("gmb", 0)
        val add = intent.getStringExtra("add")

        //menggabungkan data ke tampilan
        aksi.setTitle(nama)
        textView2.text=nama
        textView5.text=deskripsi
        imageView5.setImageResource(gambar)
        textView4.text=add
    }
}