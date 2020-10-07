package com.example.projeto_mobile

import java.io.Serializable

class Category: Serializable {
    var id: Long = 0
    var name = ""

    override fun toString(): String {
        return "Categoria $name"
    }
}