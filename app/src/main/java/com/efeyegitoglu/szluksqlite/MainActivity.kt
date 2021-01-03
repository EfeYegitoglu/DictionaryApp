package com.efeyegitoglu.szluksqlite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.info.sqlitekullanimihazirveritabani.DatabaseCopyHelper
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), SearchView.OnQueryTextListener {

    private lateinit var kelimelerList: ArrayList<Kelimeler>
    private lateinit var adapter: KelimelerAdapter
    private lateinit var vt: Veritabani

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        vt = Veritabani(this)

        veritabanıKopyala()

        toolbar.title = "Sözlük Uygulaması"
        setSupportActionBar(toolbar)

        rv.setHasFixedSize(true)
        rv.layoutManager = LinearLayoutManager(this)



        kelimelerList = Kelimelerdao().tumKelimeler(vt)


        adapter = KelimelerAdapter(this, kelimelerList)

        rv.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)

        val item = menu.findItem(R.id.action_ara)

        val searchView = item.actionView as SearchView
        searchView.setOnQueryTextListener(this)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onQueryTextSubmit(query: String): Boolean {

        arama(query)
        Log.e("arama",query)

        return false
    }

    override fun onQueryTextChange(newText: String): Boolean {

        arama(newText)
        Log.e("arama",newText)

        return false
    }

    fun veritabanıKopyala() {
        val copyHelper = DatabaseCopyHelper(this)

        try {
            copyHelper.createDataBase()
            copyHelper.openDataBase()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun arama(aramaKelime: String) {

        kelimelerList = Kelimelerdao().aramaYap(vt, aramaKelime)


        adapter = KelimelerAdapter(this, kelimelerList)

        rv.adapter = adapter

    }
}
