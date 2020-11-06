package com.example.projeto_mobile

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.GsonBuilder
import java.io.Serializable

@Entity(tableName="pergunta")
class Pergunta: Serializable {

    @PrimaryKey
    var id: Long = 0
    var categoria = ""
    var pergunta = ""
    var alt_um = ""
    var alt_dois = ""
    var alt_tres = ""
    var alt_quatro = ""
    var resposta_certa = ""

    override fun toString(): String {

        return "Pergunta $categoria"
    }
    fun toJson(): String {
        return GsonBuilder().create().toJson(this)
    }
}