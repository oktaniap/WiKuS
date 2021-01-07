package com.example.wikus

import android.app.Activity
import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wikus.catatan.Note
import kotlinx.android.synthetic.main.activity_catatan.*

class CatatanActivity : AppCompatActivity() {
    companion object {
        const val ADD_NOTE_REQUEST = 1
        const val EDIT_NOTE_REQUEST = 2
    }

    private lateinit var noteViewModel: NoteViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_catatan)
        //mengatur action bar
        val aksi : ActionBar?=supportActionBar
        aksi!!.setDisplayHomeAsUpEnabled(true)
        aksi!!.setDisplayShowHomeEnabled(true)
        val nama = "Wishlist"
        aksi.setTitle(nama)
        //action ketika button add diklik
        buttonAddNote.setOnClickListener {
            startActivityForResult(
                Intent(this, AddEditNoteActivity::class.java),
                ADD_NOTE_REQUEST
            )
        }
        //mengatur adapter dari recylerview
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.setHasFixedSize(true)
        val adapter = NoteAdapter()
        recycler_view.adapter = adapter

        noteViewModel = ViewModelProviders.of(this).get(NoteViewModel::class.java)
        noteViewModel.getAllNotes().observe(this, Observer<List<Note>> {
            adapter.submitList(it)
        })

        ItemTouchHelper(

            object :
                ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT.or(ItemTouchHelper.RIGHT).or(
                    ItemTouchHelper.DOWN)) {

                override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean {
                    return false

                }

                override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {

                    //  cardview.setCardBackgroundColor(Color.parseColor("Red"))
                    AlertDialog.Builder(viewHolder.itemView.getContext())
                        // Judul
                        .setTitle("Warning")
                        // Pesan yang di tamopilkan
                        .setMessage("Ingin Dihapus ?")
                        .setPositiveButton("Ya", DialogInterface.OnClickListener(){ dialogInterface, i ->
                            noteViewModel.delete(adapter.getNoteAt(viewHolder.adapterPosition))
                            Toast.makeText(baseContext, "Wishlist dihapus!", Toast.LENGTH_SHORT).show()
                        })
                        .setNegativeButton("Tidak", DialogInterface.OnClickListener { dialogInterface, i ->
                            Toast.makeText(baseContext, "Wishlist Tidak Terhapus", Toast.LENGTH_LONG).show()
                            adapter.notifyItemChanged(viewHolder.adapterPosition)
                        })
                        .show()

                }
            }
        ).attachToRecyclerView(recycler_view)
        adapter.setOnItemClickListener(object : NoteAdapter.OnItemClickListener {
            override fun onItemClick(note: Note) {
                val intent = Intent(baseContext, AddEditNoteActivity::class.java)
                intent.putExtra(AddEditNoteActivity.EXTRA_ID, note.id)
                intent.putExtra(AddEditNoteActivity.EXTRA_JUDUL, note.title)
                intent.putExtra(AddEditNoteActivity.EXTRA_DESKRIPSI, note.description)

                intent.putExtra(AddEditNoteActivity.EXTRA_PRIORITAS, note.priority)

                startActivityForResult(intent, EDIT_NOTE_REQUEST)             }
        }
        )
    }
    //membuat tampilan menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true     }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item?.itemId) {
            R.id.delete_all_notes -> {
                noteViewModel.deleteAllNotes()
                Toast.makeText(this, "Semua sudah dihapus!", Toast.LENGTH_SHORT).show()
                true
            }
            else -> {
                super.onOptionsItemSelected(item)
            }
        }
    }
    //aktivitas setelah dari aktivitas lain
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == ADD_NOTE_REQUEST && resultCode == Activity.RESULT_OK) {
            val newNote = Note(
                data!!.getStringExtra(AddEditNoteActivity.EXTRA_JUDUL),
                data.getStringExtra(AddEditNoteActivity.EXTRA_DESKRIPSI),
                data.getIntExtra(AddEditNoteActivity.EXTRA_PRIORITAS, 1)
            )
            noteViewModel.insert(newNote)
            Toast.makeText(this, "Wishlist disimpan!", Toast.LENGTH_SHORT).show()
        } else if (requestCode == EDIT_NOTE_REQUEST && resultCode == Activity.RESULT_OK) {
            val id = data?.getIntExtra(AddEditNoteActivity.EXTRA_ID, -1)

            if (id == -1) {
                Toast.makeText(this, "Pembaharuan gagal!", Toast.LENGTH_SHORT).show()
            }

            val updateNote = Note(
                data!!.getStringExtra(AddEditNoteActivity.EXTRA_JUDUL),
                data.getStringExtra(AddEditNoteActivity.EXTRA_DESKRIPSI),
                data.getIntExtra(AddEditNoteActivity.EXTRA_PRIORITAS, 1)
            )
            updateNote.id = data.getIntExtra(AddEditNoteActivity.EXTRA_ID, -1)
            noteViewModel.update(updateNote)
        } else {
            Toast.makeText(this, "Wishlist tidak disimpan!", Toast.LENGTH_SHORT).show()
        }
    }
}