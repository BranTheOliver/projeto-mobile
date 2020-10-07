package com.example.projeto_mobile

import android.content.Context
import java.security.AccessControlContext

object CategoryService {
    fun getCategory(context: Context): List<Category>{
        val categories = mutableListOf<Category>()

        for(i in 1..5){
            val c = Category()
            c.name = "categoria: $i"
            categories.add(c)
        }
        return categories
    }
}