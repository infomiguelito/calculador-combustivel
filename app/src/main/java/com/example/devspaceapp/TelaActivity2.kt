package com.example.devspaceapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText


class TelaActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_tela2)

        val kilometres = findViewById<TextInputEditText>(R.id.edt_km)

        val btn_proximo = findViewById<Button>(R.id.btn_proximo)

        btn_proximo.setOnClickListener{

            val kmStr  : String =  kilometres.text.toString()

            if (kmStr == ""){
              Snackbar.make(kilometres,"preencha",Snackbar.LENGTH_LONG).show()

            }else {

                val km : Float = kilometres.text.toString().toFloat()

            val intent = Intent(this, TelaActivity3::class.java)
            intent.putExtra(KEY_UM,km)
            startActivity(intent)}


        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}