package com.example.projeto_mobile

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class PerguntaAdapter (
    val perguntas: List<Pergunta>,
    val onClick: (Pergunta) -> Unit):
        RecyclerView.Adapter<PerguntaAdapter.PerguntasViewHolder>(){

    class PerguntasViewHolder(view: View): RecyclerView.ViewHolder(view){
        val cardNome: TextView
        val cardView: CardView

        init {
            cardNome = view.findViewById<TextView>(R.id.card_template)
            cardView = view.findViewById<CardView>(R.id.card_pergunta)
        }

    }

    override fun getItemCount() = this.perguntas.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PerguntasViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.adapter_pergunta, parent,false)
        val holder = PerguntasViewHolder(view)
        return holder

    }

    override fun onBindViewHolder(holder: PerguntasViewHolder, position: Int) {
        val context = holder.itemView.context

        val pergunta = perguntas[position]

        holder.cardNome.text = "Tipo: ${pergunta.categoria}"

        holder.itemView.setOnClickListener{onClick(pergunta)}
    }

}