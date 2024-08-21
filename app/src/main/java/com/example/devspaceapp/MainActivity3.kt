package com.example.devspaceapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

const val KEY_UM = "TelaActivity3.quilometros"

class MainActivity3 : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main3)

        val distancia = intent.getFloatExtra(KEY_UM, 0f)


        val edt_kml = findViewById<TextInputEditText>(R.id.edt_kml)
        val btn_proximo3 = findViewById<Button>(R.id.btn_proximo3)
        val kmlStr = edt_kml.text

        btn_proximo3.setOnClickListener {


            if (kmlStr.toString().isNotEmpty()) {
                val kml: Float = edt_kml.text.toString().toFloat()

                val intent = Intent(this, MainActivity4::class.java)
                intent.putExtra(KEY_DOIS, kml)
                intent.putExtra(KEY_UM, distancia.toString().toFloat())
                startActivity(intent)
            } else {
                Snackbar.make(edt_kml, "preencha", Snackbar.LENGTH_LONG).show()
            }
        }



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}