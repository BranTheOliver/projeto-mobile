package com.example.projeto_mobile

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Pergunta::class), version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun perguntaDAO(): PerguntaDAO
}