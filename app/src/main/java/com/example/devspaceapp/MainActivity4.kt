package com.example.devspaceapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

const val KEY_DOIS = "TelaActivity_4.consumo"


class MainActivity4 : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main4)

        val distance = intent.getFloatExtra(KEY_UM, 0f)


        val consume = intent.getFloatExtra(KEY_DOIS, 0f)
        println("consumo" + consume)

        val edt_preco = findViewById<TextInputEditText>(R.id.edt_preco)
        val btn_calcular = findViewById<Button>(R.id.btn_proximo_4)

        val preco = edt_preco.text

        btn_calcular.setOnClickListener {

            if (preco.toString() == "") {
                Snackbar.make(edt_preco,"preencha",Snackbar.LENGTH_LONG).show()
            } else {
                val resultado = distance * (preco.toString().toFloat() / consume)
                Intent(this, ResultActivity5::class.java).apply {
                    putExtra("preco", resultado.toString().toFloat())
                    startActivity(this)
                }
            }

        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}