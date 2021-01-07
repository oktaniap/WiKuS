package com.example.wikus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_wisata.*

class WisataActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wisata)
        //mengatur action bar
        val aksi : ActionBar?=supportActionBar
        aksi!!.setDisplayHomeAsUpEnabled(true)
        aksi!!.setDisplayShowHomeEnabled(true)
        val nama = "Wisata"
        aksi.setTitle(nama)
        //mengelola adapter dan data
        val list = ArrayList<wisata>()
        val adapter= wisata_adapter(list, this)
        recycler_view.layoutManager= LinearLayoutManager(this)
        recycler_view.adapter=adapter
        //mengisi data class
        list.add(wisata("Pulau Sarinah", R.drawable.wisata1, "Pulau Sarinah merupakan hasil sedimentasi dari semburan Lumpur Lapindo yang telah terjadi sejak tahun 2006 yang lalu. Saat ini Pulau Sarinah yang memiliki luas sekitar 80 hektar ini telah ditanami dengan pohon bakau dan berbagai jenis tanaman lainnya. Karena keberadaan tanaman-tanaman tersebut, pulau ini menjadi sangat asri dan terasa nyaman untuk disinggahi.","Desa Tlocor, Kec. Jabon, Sidoarjo"))
        list.add(wisata("Wisata Lumpur Lapindo", R.drawable.wisata2, "Wisata ini berakar dari tragedi lumpur Lapindo. Wisata lumpur Lapindo merupakan objek wisata yang menawarkan daya tarik lain dari yang lainnya. Di tempat ini wisatawan dapat menemui puluhan patung unik yang mirip dengan orang tenggelam di kubangan lumpur.", "Jalan Raya Tanggulangin, Ketapang, Sidoarjo"))
        list.add(wisata("Museum Mpu Tantular", R.drawable.wisata3, "Museum Mpu Tantular memiliki luas sekitar 3,3, hektar. Di museum ini dapat melihat berbagai macam benda bersejarah dari golongan: peninggalan kerajaan, geologi, biologi, etnografi, dan numismatika", "Jalan Buduran, Sidoarjo"))
        list.add(wisata("Candi Pari", R.drawable.wisata4, "Candi Pari merupakan bagian dari pola Candi Khamer yang ada di Birma dan Candi Champa yang ada di Thailand. Secara bentuk, candi yang didirikan pada pemerintahan Raja Hayam Wuruk ini cenderung sangat berbeda dengan bangunan candi peninggalan Majapahit yang lainnya. Sampai saat ini, Candi Pari masug digunakan sebagai tempat ibadah oleh para penganut agama Hindu.", ""))
        list.add(wisata("Suncity Waterpark", R.drawable.wisata5, "Suncity Waterpark merupakan wisata yang sangat cocok untuk dikunjungi bersama dengan keluarga. Di waterpark ini, ada banyak wahana permainan air yang bisa dinikmati baik oleh anak-anak maupun oleh orang dewasa. Dari mulai wahana air mancur, lazy river, dragon sliding, sampai dengan wahana mandi busa.", "Jalan Pahlawan No. 1 Sidoarjo"))
        list.add(wisata("Taman Abhirama", R.drawable.wisata6, "Taman Abhirama merupakan taman terbuka hijau yang sangat tertata rapi. Taman ini telah dilengkapi dengan beberapa fasilitas umum seperti gazebo, tempat duduk, air mancur, dan arena khusus untuk tempat bermain anak.", "Pagerwojo, Buduran, Sidoarjo"))
        list.add(wisata("Pasar Malam Gading Fajar", R.drawable.wisata7, "Pasar Malam Gading Fajar merupakan pasar malam permanen yang berlokasi di Perumahan Taman Pinang - Gading Fajar. Secara keseluruhan, pasar malam ini cenderung sangat mirip dengan Jalan Malioboro yang ada di Yogyakarta. Pasar Malam Gading Fajar hanya beroperasi dari mulai pukul 16.00 sampai dengan pukul 23.30.", "Perumahan Taman Pinang - Gading Fajar"))
        list.add(wisata("Wisata Kampoeng Batik Jetis", R.drawable.wisata8, "Kabupaten Sidoarjo memang bukan kota batik. Namun, Sidoarjo telah menjadi salah satu pusat pengrajin sejak tahun 1675. Salah satu daerah yang menjadi pusat kerajinan batik tulis di Sidoarjo ada di Kampoeng Batik Jetis. Di kampung ini dapat membeli berbagai macam produk batik dengan harga yang bervariatif. Kampung ini juga menyediakan untuk yang ingin belajar membatik.", "Jalan P. Diponegoro Lemahputro"))
        list.add(wisata("Wisata Kampung Sepatu Krian", R.drawable.wisata9, "Secara keseluruhan, Kampung Sepatu Krian sangat mirip dengan Desa Cibaduyut yang ada di Bandung. Di kampung ini pengunjung dapat membeli berbagai jenis sepatu dengan harga yang sangat terjangkau.", "Kelurahan Masangan, Kec. Krian, Sidoarjo"))
        list.add(wisata("Legok Asri Sukolegok", R.drawable.wisata10, "Legok Asri Sukolegok merupakan tempat wisata keluarga yang sangat kaya akan fasilitas. Objek wisata yang memiliki luas total sekitar 3 hektar ini telah dilengkapi dengan kolam renang, wisata outbound, kolam pancing, gazebo, tempat makan, area bermain khusus anak-anak, dll.", "Jalan Raya Sukolegok, Kec. Sukodono, Sidoarjo"))
        list.add(wisata("Kebun Coklat Balongbendo", R.drawable.wisata11, "Walaupun bernama kebun coklat, sejatinya objek wisata ini adalah sebuah kafe yang mengusung konsep kebun coklat. Di kafe ini bisa menemui berbagai macam olahan kuliner seperti mi cower, mi gobyor, dan berbagai macam olahan kuliner khas nusantara.", "Desa Penambangan, Balongbendo, Sidoarjo"))
        list.add(wisata("Pantai Kepetingan", R.drawable.wisata12, "Pantai Kepetingan menawarkan pengalaman wisata yang sangat lengkap, mulai dari wisata pantai, wisata hutan bakau, wisata religi, sampai dengan wisata budaya, semuanya dapat dinikmati di pantai ini.", "Desa Sawohan, Kec. Buduran, Sidoarjo"))
        list.add(wisata("Alun-alun Sidoarjo", R.drawable.wisata13, "Alun-Alun Sidoarjo berlokasi di pusat kota Sidoarjo. Alun-Alun ini telah dilengkapi dengan berbagai macam fasilitas seperti tempat duduk, jogging track, dll. Di lokasi alun-alun juga bisa memesan berbagai macam olahan kuliner khas Sidoarjo. Jika anda ingin berkeliling namun malas berjalan kaki anda dapat memanfaatkan fasilitas kereta kuda yang banyak tersedia di sekitar alun-alun.", "Kec. Sidoarjo, Sidoarjo"))
        list.add(wisata("Delta Fishing", R.drawable.wisata14, "Di objek wisata ini dapat menyalurkan hobi memancing. Setiap kolam pancing yang tersedia disini diisi dengan jenis ikan yang berbeda-beda ada yang diisi dengan ikan patin, ada yang diisi dengan ikan gurame, ada yang diisi dengan ikan bawal, dan ada pula yang diisi dengan ikan tombro. Selain menawarkan kolam pemancingan tempat wisata ini juga turut menawarkan berbagai macam wahana permainan yang ditunjukkan untuk keluarga, mulai dari sepeda air main, flying fox sampai dengan kolam renang semua telah tersedia di sini.", "Jalan Mbah Sholeh No. 1 Buduran, Sidoarjo"))
        list.add(wisata("Pazkul Kahuripan Nirwana", R.drawable.wisata15, "Pazkul Kahuripan Nirwana merupakan pusat kulinernya kota Sidoarjo. Disini bisa ditemui berbagai macam olahan kuliner tradisional khas Jawa dan olahan kuliner modern dengan harga yang cukup terjangkau. Selain menawarkan olahan kuliner yang lengkap, pazkul Kahuripan Nirwana juga turut menawarkan tempat nongkrong yang luar biasa kece dan menarik. Konsep yang diusung oleh tempat ini adalah foodcourt luar ruangan berbasis Go Green.", "Jalan Kahuripan No. 7 Entalsewu, Sidoarjo"))
    }

}