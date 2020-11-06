package com.example.projeto_mobile

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken

object PerguntaService {
    val host = "https://brantheoliver.pythonanywhere.com"
    val TAG = "WS_AC05"
    fun getPerguntas(context: Context): List<Pergunta> {
        if (AndroidUtils.isInternetDisponivel()) {
            val url = "$host/perguntas"
            val json = HttpHelper.get(url)
            val pergunta = parserJson<List<Pergunta>>(json)

            for(p in pergunta) {
                saveOffline(p)
            }

            return pergunta
        }else{
            val dao = DatabaseManager.getPerguntaDAO()
            val perguntas = dao.getAll()
            return perguntas
        }

    }

    inline fun <reified T> parserJson(json: String): T {
        val type = object : TypeToken<T>() {}.type
        return Gson().fromJson<T>(json, type)
        }

    fun savePergunta(pergunta: Pergunta) {
        if (AndroidUtils.isInternetDisponivel()){
            val json = HttpHelper.post("$host/pergunta", pergunta.toJson())
            return parserJson(json)
        }else{
            saveOffline(pergunta)
        }
    }

    fun saveOffline(pergunta: Pergunta) : Boolean {
        val dao = DatabaseManager.getPerguntaDAO()

        if (! existePergunta(pergunta)) {
            dao.insert(pergunta)
        }

        return true
    }

    fun existePergunta(pergunta: Pergunta) : Boolean{
        val dao = DatabaseManager.getPerguntaDAO()
        return dao.getById(pergunta.id) != null
    }

}