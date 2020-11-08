package com.example.projeto_mobile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_teste.*

class TesteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teste)
        var pergunta = intent.getSerializableExtra("pergunta") as Pergunta
        teste.text = pergunta?.pergunta
    }
}