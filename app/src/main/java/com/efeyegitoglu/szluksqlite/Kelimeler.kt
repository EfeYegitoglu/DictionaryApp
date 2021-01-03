package com.efeyegitoglu.szluksqlite

import java.io.Serializable

data class Kelimeler(
    var kelime_id: Int,
    var ingilizce: String,
    var turkce: String
) : Serializable {
}