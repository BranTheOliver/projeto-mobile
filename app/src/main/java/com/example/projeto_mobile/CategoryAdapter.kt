package com.example.projeto_mobile

import android.service.autofill.OnClickAction
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class CategoryAdapter (
    val categories: List<Category>,
    val onClick: (Category) -> Unit):
        RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>(){

    class CategoryViewHolder(view: View): RecyclerView.ViewHolder(view){
        val cardNome: TextView
        val cardView: CardView

        init {
            cardNome = view.findViewById<TextView>(R.id.cardTemplate)
            cardView = view.findViewById<CardView>(R.id.cardCategory)
        }

    }

    override fun getItemCount() = this.categories.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.adapter_category, parent,false)
        val holder = CategoryViewHolder(view)
        return holder

    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val context = holder.itemView.context

        val category = categories[position]

        holder.cardNome.text = category.name

        holder.itemView.setOnClickListener{onClick(category)}
    }

}