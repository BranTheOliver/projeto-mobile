package com.example.projeto_mobile

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_pergunta.*
import kotlinx.android.synthetic.main.adapter_pergunta.*
import kotlinx.android.synthetic.main.toolbar.*
import kotlin.concurrent.thread

@Suppress("DEPRECATION")
class PerguntaActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private val context: Context get() = this
    private var perguntas = listOf<Pergunta>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pergunta)

        setSupportActionBar(toolbar_view)

        supportActionBar?.title = "Perguntas"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        configuraMenuLateral()

        recycler_pergunta?.layoutManager = LinearLayoutManager(context)
        recycler_pergunta?.itemAnimator = DefaultItemAnimator()
        recycler_pergunta?.setHasFixedSize(true)
        }


    override fun onResume() {
        super.onResume()
        taskPerguntas()
    }

    fun taskPerguntas(){
        Thread{
            perguntas = PerguntaService.getPerguntas(context)
            runOnUiThread {
                recycler_pergunta?.adapter = PerguntaAdapter(perguntas) {onClickPergunta(it)}
                enviarNotificacao()
            }
        }.start()
    }

    fun enviarNotificacao(){
        val intent = Intent(this, PerguntaActivity::class.java)
        NotificationUtil.create(1, intent, "Bem Vindo!", "Seja bem vindo ao aplicativo de perguntas e respostas!")
    }

    fun onClickPergunta(pergunta: Pergunta) {
        val intent = Intent(context, TesteActivity::class.java)
        intent.putExtra("pergunta", pergunta)
        startActivity(intent)
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
                Toast.makeText(this, "Perguntas", Toast.LENGTH_SHORT).show()
            }
            R.id.perfil -> {
                Toast.makeText(this, "Perfil", Toast.LENGTH_SHORT).show()
            }
            R.id.ajuda -> {
                Toast.makeText(this, "Ajuda", Toast.LENGTH_SHORT).show()
            }
            R.id.localizacao -> {
                val intent = Intent(context, MapasActivity::class.java)
                startActivity(intent)
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
            val it = Intent(context, NovaPerguntaActivity::class.java)
            startActivity(it)
        }

        return super.onOptionsItemSelected(item)
    }
}

