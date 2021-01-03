package com.efeyegitoglu.szluksqlite

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class KelimelerAdapter(private val mContext: Context, private val mList: List<Kelimeler>) :
    RecyclerView.Adapter<KelimelerAdapter.CardTasarimTutucu>() {

    inner class CardTasarimTutucu(tasarim: View):RecyclerView.ViewHolder(tasarim) {
        var kelime_card:CardView
        var textIng:TextView
        var textTr:TextView
        init {
            kelime_card=tasarim.findViewById(R.id.kelime_card)
            textIng=tasarim.findViewById(R.id.textIng)
            textTr=tasarim.findViewById(R.id.textTr)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val tasarim=LayoutInflater.from(mContext).inflate(R.layout.card_tasarim,parent,false)
        return CardTasarimTutucu(tasarim)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val kelime=mList.get(position)

        holder.textIng.text=kelime.ingilizce
        holder.textTr.text=kelime.turkce

        holder.kelime_card.setOnClickListener {
            val intent=Intent(mContext,DetayActivity::class.java)
            intent.putExtra("nesne",kelime)
            mContext.startActivity(intent)

        }
    }


}