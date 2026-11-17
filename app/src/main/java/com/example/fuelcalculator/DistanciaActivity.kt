package com.example.fuelcalculator

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.appbar.MaterialToolbar

class DistanciaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_distancia)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.edtPrecoLitroCalcular)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val toolbar = findViewById<MaterialToolbar>(R.id.toolbarDistancia)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        val edtDistancia = findViewById<EditText>(R.id.edtDistancia)
        val btnDistanciaProximo = findViewById<Button>(R.id.btnDistanciaProximo)

        btnDistanciaProximo.setOnClickListener {

            val textoDistancia = edtDistancia.text.toString()
            val distanciaValor = edtDistancia.text.toString().replace(",", ".").toDoubleOrNull() ?: 0.0

        //Barrar usuário caso deixe o campo em branco

            if (textoDistancia.isEmpty() || distanciaValor <= 0.0) {
                edtDistancia.error = "Preenchimento Obrigatório"
                return@setOnClickListener
            }

            val intent = Intent(this, ConsumoActivity::class.java)
            intent.putExtra("DISTANCIA", distanciaValor)
            startActivity(intent)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            android.R.id.home ->{
                finish()
                true
            }

            else -> super.onOptionsItemSelected(item)

        }
    }
}