package com.example.projeto_mobile

import androidx.room.Room

object DatabaseManager {
    private var dbInstance: AppDatabase
    init {

        val context  = AppApplication.getInstance().applicationContext
        dbInstance = Room.databaseBuilder(context, AppDatabase::class.java, "app.sqlite").build()
    }
    fun getPerguntaDAO(): PerguntaDAO{
        return dbInstance.perguntaDAO()
    }
}