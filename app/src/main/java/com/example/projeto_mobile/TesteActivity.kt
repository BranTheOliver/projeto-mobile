package com.example.projeto_mobile

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_teste.*
import kotlinx.android.synthetic.main.toolbar.*
import java.text.FieldPosition

class TesteActivity : AppCompatActivity(), View.OnClickListener {
    private var mSelectedOption = ""
    private var mSelectedOptionNum = 0
    private var op1 = ""
    private var op2 = ""
    private var op3 = ""
    private var op4 = ""
    private var certa = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teste)
        var pergunta = intent.getSerializableExtra("pergunta") as Pergunta
        op1 = pergunta?.alt_um
        op2 = pergunta?.alt_dois
        op3 = pergunta?.alt_tres
        op4 = pergunta?.alt_quatro
        certa = pergunta?.resposta_certa

        enunciado.text = pergunta?.pergunta
        opcao1.text = pergunta?.alt_um
        opcao2.text = pergunta?.alt_dois
        opcao3.text = pergunta?.alt_tres
        opcao4.text = pergunta?.alt_quatro

        opcao1.setOnClickListener(this)
        opcao2.setOnClickListener(this)
        opcao3.setOnClickListener(this)
        opcao4.setOnClickListener(this)
        enviar.setOnClickListener(this)
    }

    override fun onClick(v: View?){
        when (v?.id) {
            R.id.opcao1 ->{
                selectedOptionView(opcao1,op1, 1)
            }
            R.id.opcao2 ->{
                selectedOptionView(opcao2,op2, 2)
            }
            R.id.opcao3 ->{
                selectedOptionView(opcao3,op3, 3)
            }
            R.id.opcao4 ->{
                selectedOptionView(opcao4,op4, 4)
            }
            R.id.enviar ->{
                if (mSelectedOption == ""){
                    Toast.makeText(this, "Selecione alguma opção!", Toast.LENGTH_LONG).show()
                }else{
                    if(mSelectedOption == certa){
                        Toast.makeText(this, "Resposta correta!", Toast.LENGTH_LONG).show()
                        answerView(mSelectedOptionNum, "#00FF00")
                    }else{
                        Toast.makeText(this, "Resposta incorreta!", Toast.LENGTH_LONG).show()
                        answerView(mSelectedOptionNum, "#FF0000")
                    }
                }
            }

        }
    }

    private fun selectedOptionView(op: TextView?, selectedOption: String, pos: Int) {
        mSelectedOption = selectedOption
        mSelectedOptionNum = pos
        defaultOptionsView()
        op?.setBackgroundColor(Color.parseColor("#D4D4D5"))
    }
    private fun defaultOptionsView() {
        val options = ArrayList<TextView>()
        options.add(opcao1)
        options.add(opcao2)
        options.add(opcao3)
        options.add(opcao4)

        for(op in options){
            op.setBackgroundColor(Color.parseColor("#FFFFFF"))
        }
    }

    private fun answerView(answer: Int, color: String){
        when(answer){
            1 -> {
                opcao1.setBackgroundColor(Color.parseColor(color))
            }
            2 -> {
                opcao2.setBackgroundColor(Color.parseColor(color))
            }
            3 -> {
                opcao3.setBackgroundColor(Color.parseColor(color))
            }
            4 -> {
                opcao4.setBackgroundColor(Color.parseColor(color))
            }
        }
    }

}