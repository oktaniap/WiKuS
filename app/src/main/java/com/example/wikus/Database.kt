package com.example.wikus

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

//sebagai database user
class Database(context: Context) : SQLiteOpenHelper (context, dbname, factory, version) {

    //membuat table
    override fun onCreate(p0: SQLiteDatabase?) {
        p0?.execSQL("create table user (id integer primary key autoincrement, " + "nama varchar (50), " + "username varchar (50), " + "password varchar(50))")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {

    }

    //fungsi insert
    fun insertUserData(nama: String, username: String, password: String): Boolean {
        val db :SQLiteDatabase = writableDatabase
        val values = ContentValues()
        values.put("nama", nama)
        values.put("username", username)
        values.put("password", password)
        val query = "select * from user where username = '$username'"
        val cursor = db.rawQuery(query, null)
        if (cursor.count > 0) {
            cursor.close()
            db.close()
            return false
        } else {
            db.insert("user", null, values)
            cursor.close()
            db.close()
            return true
        }
    }

    //fungsi select
    fun userPresent(username: String, password: String) : Boolean {
        val db = writableDatabase
        val query = "select * from user where username = '$username' and password = '$password'"
        val cursor = db.rawQuery(query, null)
        if (cursor.count <= 0) {
            cursor.close()
            return false
        } else {
            cursor.close()
            return true
        }
    }

    companion object {
        internal val dbname = "userDB"
        internal val factory = null
        internal val version = 1
    }
}