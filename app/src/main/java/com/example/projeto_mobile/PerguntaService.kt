package com.example.projeto_mobile

import android.content.Context

object PerguntaService {
    fun getPerguntas(context: Context): List<Pergunta>{
        val perguntas = mutableListOf<Pergunta>()

        for(i in 1..5){
            val p = Pergunta()
            p.tipo = "Pergunta $i - Tipo"
            p.altUm = ""
            p.altDois = ""
            p.altTres = ""
            p.altQuatro = ""
            p.altCerta = ""
            perguntas.add(p)
        }
        return perguntas
    }
}