package com.example.projeto_mobile

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PerguntaDAO {
    @Query("SELECT * FROM pergunta WHERE id = :id")
    fun getById(id: Long): Pergunta?

    @Query("SELECT * FROM pergunta")
    fun getAll() : List<Pergunta>

    @Insert
    fun insert(pergunta: Pergunta)

    @Delete
    fun delete(pergunta: Pergunta)
}