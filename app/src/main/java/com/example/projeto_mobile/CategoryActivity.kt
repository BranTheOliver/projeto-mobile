package com.example.projeto_mobile

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_category2.*
import kotlinx.android.synthetic.main.toolbar.*

@Suppress("DEPRECATION")
class CategoryActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private val context: Context get() = this
    private var categories = listOf<Category>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category2)

        setSupportActionBar(toolbar_view)

        supportActionBar?.title = "Categorias"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        configuraMenuLateral()

        recyclerCategory?.layoutManager = LinearLayoutManager(context)
        recyclerCategory?.itemAnimator = DefaultItemAnimator()
        recyclerCategory?.setHasFixedSize(true)
    }

    override fun onResume() {
        super.onResume()
        taskCategories()
    }

    fun taskCategories(){
        categories = CategoryService.getCategory(context)
        recyclerCategory?.adapter = CategoryAdapter(categories) {onClickCategory(it)}
    }

    fun onClickCategory(category: Category) {
        Toast.makeText(context, "${category.name}", Toast.LENGTH_SHORT).show()
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
                Toast.makeText(this, "Categorias", Toast.LENGTH_SHORT).show()
            }
            R.id.perfil -> {
                Toast.makeText(this, "Perfil", Toast.LENGTH_SHORT).show()
            }
            R.id.ajuda -> {
                Toast.makeText(this, "Ajuda", Toast.LENGTH_SHORT).show()
            }
            R.id.sair -> {
//                Toast.makeText(this, "Clicou Disciplinas", Toast.LENGTH_SHORT).show()
                finish()
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
            Toast.makeText(this, "Buscar", Toast.LENGTH_LONG).show()
        } else if (id == android.R.id.home) {
            finish()
        } else if (id == R.id.action_adicionar) {
            Toast.makeText(this, "Adicionar", Toast.LENGTH_LONG).show()
        }

        return super.onOptionsItemSelected(item)
    }
}

