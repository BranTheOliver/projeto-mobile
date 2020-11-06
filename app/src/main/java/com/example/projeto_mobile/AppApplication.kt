package com.example.projeto_mobile

import android.app.Application

class AppApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        appInstance = this
    }
    companion object{
        private var appInstance: AppApplication? = null
        fun getInstance() : AppApplication {
            if (appInstance == null) {
                throw IllegalStateException("Configurar application")
            }
            return appInstance!!
        }
    }
}