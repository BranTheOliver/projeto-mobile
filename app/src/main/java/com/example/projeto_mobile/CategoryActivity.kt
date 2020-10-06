package com.example.projeto_mobile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_category2.*
import kotlinx.android.synthetic.main.toolbar.*

@Suppress("DEPRECATION")
class CategoryActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category2)

        setSupportActionBar(toolbar_view)

        supportActionBar?.title = "Categorias"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        configuraMenuLateral()
    }

    private fun configuraMenuLateral () {
        var toogle = ActionBarDrawerToggle(
            this,
            layoutMenuLateral,
            toolbar_view,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close)
        layoutMenuLateral.addDrawerListener(toogle)
        toogle.syncState()
        menu_lateral.setNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.categorias -> {
                Toast.makeText(this, "Clicou Disciplinas", Toast.LENGTH_SHORT).show()
            }
            R.id.perfil -> {
                Toast.makeText(this, "Clicou Disciplinas", Toast.LENGTH_SHORT).show()
            }
            R.id.ajuda -> {
                Toast.makeText(this, "Clicou Disciplinas", Toast.LENGTH_SHORT).show()
            }
            R.id.sair -> {
                Toast.makeText(this, "Clicou Disciplinas", Toast.LENGTH_SHORT).show()
            }
        }

        layoutMenuLateral.closeDrawer(GravityCompat.START)
        return true
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

