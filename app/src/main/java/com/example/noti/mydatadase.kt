package com.example.noti

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import java.io.Console

class mydatadase(context:Context):SQLiteOpenHelper(context,"details.db",null,1){
    var sqldb:SQLiteDatabase=writableDatabase

    override fun onCreate(db: SQLiteDatabase?) {
        if(db!=null){
            db.execSQL("Create table note(Name Text,Description Text)")
        }    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {}


    fun save(s1:String,s2:String):Long{
        var cv=ContentValues()
        cv.put("Name",s1)
        cv.put("Description",s2)
        var status=sqldb.insert("note",null,cv)
        return status

    }
    fun retrave(s1:String):String{
        @SuppressLint("Range")
        var c: Cursor =sqldb.query("note",null,"Name=?",
            arrayOf(s1),null,null,null)
        var des:String =" "
            if(c.moveToFirst()) {

                do {
                    des = c.getString(c.getColumnIndexOrThrow("Description"))
                } while (c.moveToNext())
            }

        return des

    }
}