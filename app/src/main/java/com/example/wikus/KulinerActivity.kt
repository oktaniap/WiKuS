package com.example.wikus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_wisata.*

class KulinerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kuliner)
        //mengatur action bar
        val aksi : ActionBar?=supportActionBar
        aksi!!.setDisplayHomeAsUpEnabled(true)
        aksi!!.setDisplayShowHomeEnabled(true)
        val nama = "Wisata"
        aksi.setTitle(nama)
        //mengelola adapter dan data
        val list = ArrayList<kuliner>()
        val adapter= kuliner_adapter(list, this)
        recycler_view.layoutManager= LinearLayoutManager(this)
        recycler_view.adapter=adapter
        //mengisi data class
        list.add(kuliner("Qen-Di Garden Resto", R.drawable.kuliner1 , "Qen-Di Garden Resto merupakan restoran pertama dengan konsep taman di Sidoarjo dan tempat yang tepat untuk menghilangkan lelah dan bersantai bersama-sama dengan keluarga, menyajikan aneka menu makanan seafood, aneka makanan nasi dan mie, aneka penyetan, dan masih banyak menu spesial lainnya yang perlu dicoba.", "Taman Pinang Indah blok BB4 No. 22-24 Sidoarjo"))
        list.add(kuliner("Kupang lontong Pak Misari", R.drawable.kuliner2, "Kupang lontong Pak Misari adalah rumah makan yang khusus menjual menu olahan kupang khas dari Sidoarjo dengan cita rasa enak dan tentunya bisa menyehatkan tubuh dengan. Harga kisaran Rp10.000 dan bisa makan kenyang bisa juga ditambah dengan sate kerang dan juga minum es kelapa muda.", "Jalan Mojopahit No. 62 Bulusidokare, Sidoarjo"))
        list.add(kuliner("Iga Bakar dan Steak Sidoarjo", R.drawable.kuliner3, "Iga Bakar dan Steak Sidoarjo adalah rumah makan yang menyediakan menu kekinian seperti menu steak, iga bakar, iga penyet, lidah bakar, lidah penyet, chicken steak,  mie hotplate, dan juga food salad tidak ketinggalan aneka minuman. Lokasinya sangat strategis dan cocok buat makan bersama keluarga tercinta apalagi yang suka menu daging.", "Jalan Pahlawan No.5 Lemahputro, Sidoarjo"))
        list.add(kuliner("Warung Apung Rahmawati", R.drawable.kuliner4, "Warung Apung Rahmawati merupakan salah satu rumah makan yang sudah buka cabang di banyak tempat karena sudah cukup dikenal maka tidak mengherankan bila banyak penikmat kuliner khususnya di Jawa Timur datang untuk icip kuliner di rumah makan ini menyediakan beberapa menu pilihan seperti asam-asam gurami, kepiting telor asin, gurame bakar saus madu, kare kepiting bakar saus madu, dan masih banyak menu pilihan lainnya.", "Jalan H. Sunandar V Sidokare, Sidoarjo"))
        list.add(kuliner("Sop Buntut Langgeng Sidoarjo", R.drawable.kuliner5, "Sop Buntut Langgeng Sidoarjo merupakan salah satu rumah makan yang sudah cukup lama berdiri dan masih bertahan sampai sekarang menyediakan aneka menu iga penyet, iga panggang, buntut goreng, nasi campur, buntut penyet, sop iga, semur lodeh, nasi rawon dan menu lainnya sangat cocok sekali buat yang suka masakan sop.", "Jalan KH Mukmin No. 67 Sidokare, Sidoarjo"))
        list.add(kuliner("Rawon Gajah Mada", R.drawable.kuliner6, "Rawon Gajah Mada merupakan salah satu rumah makan dengan menu spesial nasi rawon. Sangat cocok buat pecinta menu JawaTimuran ini. Lokasi di sekitar Jalan Gajah Mada Sidoarjo strategis dan mudah akses menuju lokasi, tempat bersih dan nyaman, ada kamar mandi bersih, pelayanan ramah, menu yang tersedia ada aneka nasi rawon, aneka nasi campur, aneka pecel, dendeng, otak, dan aneka minuman.", "Jalan Gajah Mada Sidoarjo"))
        list.add(kuliner("Bebek Goreng H Slamet", R.drawable.kuliner7, "Bebek Goreng H Slamet merupakan rumah makan yang menyediakan menu masakan spesial dengan bahan dasar bebek. Bebek kriuknya maknyus dan enak sekali, pelayanannya sangat memuaskan, dan juga tempatnya cukup bersih, dan yang paling penting lagi adalah harganya yang masih cukup terjangkau, sambalnya banyak macamnya, tempat makannya juga bagus. Menu yang tersedia di rumah makan ini di antara lain aneka masakan bebek, aneka masakan ayam, roti bakar, dan aneka minuman dingin atau panas.", "Taman Pinang Indah Blok BB4 No. 16 Sidoarjo"))
        list.add(kuliner("Lesehan Joyo", R.drawable.kuliner8, "Lesehan Joyo merupakan rumah makan yang ada di Kabupaten Sidoarjo menyajikan aneka menu masakan nusantara, lokasinya cukup strategis serta tampak nyaman dan bersih, dan tentunya dengan harga yang terlatih persahabatan.", "Jalan Raya Taman Pinang Indah No. 5 Banjarbendo, Sidoarjo"))
        list.add(kuliner("Ceker Lapindho Asli", R.drawable.kuliner9, "Ceker Lapindho Asli merupakan rumah makan yang berbahan dasar ceker ayam dan sudah cukup dikenal di kawasan Sidoarjo bagi yang suka menu ceker dengan rasa yang pedas bisa langsung datang ke sini rasa ceker membawa sensasi tersendiri.", "Jalan Dr. Soetomo No. 12 Sidoarjo"))
        list.add(kuliner("Bakso Cak Pitung", R.drawable.kuliner10, "Bakso Cak Pitung terkenal murah dan enak. Antriannya tidak pernah sepi. Ada bakso keju, bakso jamur, bakso jagung, bakso urat,  bakso telur, bakso daging cincang dan bakso lombok.  Ukurannya cukup jumbo dengan harga yang ada, rasanya dijamin di atas rata-rata bakso yang ada. Maka dari itu, perlu sabar karena cukup lama antriannya.", "Jl. Gajah, Magersari di belakang Kantor Pos setelah rel kereta"))
    }
}