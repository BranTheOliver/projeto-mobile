package com.example.projeto_mobile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_nova_pergunta.*

class NovaPerguntaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nova_pergunta)
        setTitle("Nova Pergunta")
        botao_salvar.setOnClickListener{
            var p = Pergunta()
            p.pergunta = reg_pergunta.text.toString()
            p.categoria = reg_categoria.text.toString()
            p.alt_um = reg_altUm.text.toString()
            p.alt_dois = reg_altDois.text.toString()
            p.alt_tres = reg_altTres.text.toString()
            p.alt_quatro = reg_altQuatro.text.toString()
            p.resposta_certa = reg_certa.text.toString()
            taskAtualizar(p)


        }
    }

    private fun taskAtualizar(p: Pergunta) {
        Thread {
            PerguntaService.savePergunta(p)
            runOnUiThread {
                finish()
            }
        }.start()
    }
}