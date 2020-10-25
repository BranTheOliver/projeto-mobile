package com.example.projeto_mobile

import java.io.Serializable

class Pergunta: Serializable {
    var id: Long = 0
    var tipo = ""
    var pergunta = ""
    var altUm = ""
    var altDois = ""
    var altTres = ""
    var altQuatro = ""
    var altCerta = ""

    override fun toString(): String {
        return "Pergunta $tipo"
    }
}