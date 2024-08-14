package com.example.devspaceapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

const val KEY_DOIS = "TelaActivity_4.consumo"

class TelaActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_tela4)

        val distance = intent.getFloatExtra(KEY_UM, 0f)


        val consume = intent.getFloatExtra(KEY_DOIS, 0f)
        println("consumo" + consume)

        val edt_preco = findViewById<TextInputEditText>(R.id.edt_preco)
        val btn_calcular = findViewById<Button>(R.id.btn_proximo_4)

        var precoStr: String = edt_preco.text.toString()

        btn_calcular.setOnClickListener {
            if (precoStr.isNotEmpty()) {
                Snackbar.make(edt_preco, "preencha", Snackbar.LENGTH_LONG).show()

            } else {
                val resultado = distance * (precoStr.toFloat() / consume)
                println("resultado" + resultado)

                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra(chave_result, resultado)
                startActivity(intent)

            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

}