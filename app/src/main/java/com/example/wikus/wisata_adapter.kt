package com.example.wikus

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.note_item_wisata.view.*

//sebagai adapter
class wisata_adapter(private val arrayList: ArrayList<wisata>, private val context:Context): RecyclerView.Adapter<wisata_adapter.ViewHolder>() {
    //menggabungkan tampilan dengan data
    class ViewHolder(itemView:View): RecyclerView.ViewHolder(itemView){
        fun bindItems(wisata: wisata){
            itemView.text_view_title.text=wisata.nama
            itemView.imageView4.setImageResource(wisata.image)
        }
    }

    //membuat tampilan
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.note_item_wisata, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    //action setelah tampilan diklik
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //sesuai posisi masing-masing
        holder.bindItems(arrayList[position])

        //mengintent data sesuai posisi
        holder.itemView.setOnClickListener{
            val wisata = arrayList[position]
            val nama:String = wisata.nama
            val desc:String = wisata.des
            val gmb:Int = wisata.image
            val add:String = wisata.add

            val intent=Intent(context, Wisata_View_Activity::class.java)
            intent.putExtra("nama", nama)
            intent.putExtra("deskripsi", desc)
            intent.putExtra("gmb", gmb)
            intent.putExtra("add", add)
            context.startActivity(intent)

        }

    }

}