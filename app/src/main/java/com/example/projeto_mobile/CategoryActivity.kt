package com.example.projeto_mobile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.toolbar.*

@Suppress("DEPRECATION")
class CategoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category2)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        setSupportActionBar(toolbar_view)

        supportActionBar?.title = "Categorias"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item?.itemId

        if (id == R.id.action_buscar) {
            Toast.makeText(this, "Batão buscar", Toast.LENGTH_LONG).show()
        } else if (id == android.R.id.home) {
            finish()
        } else if (id == R.id.action_adicionar) {
            Toast.makeText(this, "Batão adicionar", Toast.LENGTH_LONG).show()
        }

        return super.onOptionsItemSelected(item)
    }
}

