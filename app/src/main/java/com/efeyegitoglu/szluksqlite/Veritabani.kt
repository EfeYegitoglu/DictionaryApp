package com.efeyegitoglu.szluksqlite

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class Veritabani(context: Context):SQLiteOpenHelper(context,"sozluk.sqlite",null,1) {


    override fun onCreate(db: SQLiteDatabase?) {

        db?.execSQL("CREATE TABLE IF NOT EXISTS \"kelimeler\" (\n" +
                "\t\"kelime_id\"\tINTEGER,\n" +
                "\t\"ingilizce\"\tTEXT,\n" +
                "\t\"turkce\"\tTEXT,\n" +
                "\tPRIMARY KEY(\"kelime_id\" AUTOINCREMENT)\n" +
                ");")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS kelimeler")

        onCreate(db)
    }
}