package com.example.projeto_mobile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.SYSTEM_UI_FLAG_FULLSCREEN
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        window.decorView.systemUiVisibility = SYSTEM_UI_FLAG_FULLSCREEN

        buttonAccess.setOnClickListener {onClickLogin() }

        var lembrar = Prefs.getBoolean("lembrar")
        if (lembrar) {
            var lembrarNome  = Prefs.getString("lembrarNome")
            var lembrarSenha  = Prefs.getString("lembrarSenha")
            nameUser.setText(lembrarNome)
            passWordUser.setText(lembrarSenha)
            check_lembrar.isChecked = lembrar

        }
    }
    fun onClickLogin() {
        buttonAccess.setBackgroundResource(R.color.colorButtonDark)
        var baseName = "aluno"
        var basePassWord = "impacta"

        var fieldName = nameUser.text.toString()
        var fieldPassWord = passWordUser.text.toString()
        var lembrarLogin = check_lembrar.isChecked

        Prefs.setBoolean("lembrar", lembrarLogin)
        if (lembrarLogin){
            Prefs.setString("lembrarNome", fieldName)
            Prefs.setString("lembrarSenha", fieldPassWord)
        } else {
            Prefs.setString("lembrarNome", "")
            Prefs.setString("lembrarSenha", "")
        }

        if (fieldName == baseName && fieldPassWord == basePassWord) {
            Toast.makeText(this, "Login efetuado com sucesso", Toast.LENGTH_LONG).show()

            val intent = Intent(this, PerguntaActivity::class.java)

            startActivity(intent)
        } else {
            Toast.makeText(this, "Usuário ou senha incorretos", Toast.LENGTH_LONG).show()
        }
    }
}