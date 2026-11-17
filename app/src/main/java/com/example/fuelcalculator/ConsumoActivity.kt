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
import kotlin.text.replace

class ConsumoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_consumo)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.edtPrecoLitroCalcular)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val toolbar = findViewById<MaterialToolbar>(R.id.toolbarConsumo)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        val distancia = intent.getDoubleExtra("DISTANCIA", 0.0)
        val edtConsumo = findViewById<EditText>(R.id.edtConsumo)
        val btnConsumoProximo = findViewById<Button>(R.id.btnConsumoProximo)

        btnConsumoProximo.setOnClickListener {

            val textoConsumo = edtConsumo.text.toString()
            val consumoValor = edtConsumo.text.toString().replace(",", ".").toDoubleOrNull() ?: 0.0

        //Barrar usuário caso deixe o campo em branco

            if (textoConsumo.isEmpty() || consumoValor <= 0.0){
            edtConsumo.error = "Preenchimento Obrigatório"
            return@setOnClickListener
            }

            val intent = Intent(this, PrecoLitroActivity::class.java)
            intent.putExtra("CONSUMO LITRO", consumoValor)
            intent.putExtra("DISTANCIA", distancia)
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