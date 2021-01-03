package com.efeyegitoglu.szluksqlite

class Kelimelerdao {

    fun tumKelimeler(vt: Veritabani): ArrayList<Kelimeler> {

        val kelimelerList = ArrayList<Kelimeler>()

        val db = vt.writableDatabase

        val cursor = db.rawQuery("SELECT * FROM kelimeler", null)

        while (cursor.moveToNext()) {
            val kelime = Kelimeler(
                cursor.getInt(cursor.getColumnIndex("kelime_id"))
                , cursor.getString(cursor.getColumnIndex("ingilizce"))
                , cursor.getString(cursor.getColumnIndex("turkce"))
            )

            kelimelerList.add(kelime)
        }

        return kelimelerList
    }

    fun aramaYap(vt: Veritabani, aramaKelime: String): ArrayList<Kelimeler> {

        val kelimelerList = ArrayList<Kelimeler>()

        val db = vt.writableDatabase

        val cursor =
            db.rawQuery("SELECT * FROM kelimeler WHERE ingilizce like '%$aramaKelime%'", null)

        while (cursor.moveToNext()) {
            val kelime = Kelimeler(
                cursor.getInt(cursor.getColumnIndex("kelime_id"))
                , cursor.getString(cursor.getColumnIndex("ingilizce"))
                , cursor.getString(cursor.getColumnIndex("turkce"))
            )

            kelimelerList.add(kelime)
        }

        return kelimelerList
    }
}