package com.example.wikus.catatan

import androidx.lifecycle.LiveData
import androidx.room.*

//sebagai data object access
@Dao
interface NoteDao {
    //memasukkan query insert
    @Insert
    fun insert(note: Note)
    //memasukan query update
    @Update
    fun update(note: Note)
    //memasukkan query delete
    @Delete
    fun delete(note: Note)
    //memasukkan query
    @Query("DELETE FROM note_table")
    fun deleteAllNotes()
    @Query("SELECT * FROM note_table ORDER BY priority ASC")
    fun getAllNotes(): LiveData<List<Note>>
}

