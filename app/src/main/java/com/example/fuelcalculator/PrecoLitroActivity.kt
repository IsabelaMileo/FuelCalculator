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

class PrecoLitroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_preco_litro)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.edtPrecoLitroCalcular)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val toolbar = findViewById<MaterialToolbar>(R.id.toolbarPreco)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        val distancia = intent.getDoubleExtra("DISTANCIA", 0.0)
        val consumo = intent.getDoubleExtra("CONSUMO LITRO", 0.0)


        val edtPrecoLitro = findViewById<EditText>(R.id.edtPrecoCalcular)
        val btnPrecoLitroCalcular = findViewById<Button>(R.id.btnPrecoLitroCalcular)

        btnPrecoLitroCalcular.setOnClickListener {

            val distancia = distancia
            val consumo = consumo

            val textoPreco = edtPrecoLitro.text.toString()
            val precoLitro = edtPrecoLitro.text.toString().replace(",", ".").toDoubleOrNull() ?: 0.0

            //Barrar usuário caso deixe o campo em branco
            if (textoPreco.isEmpty() || precoLitro <= 0.0) {
                edtPrecoLitro.error = "Preenchimento Obrigatório"
                return@setOnClickListener
            }

            //Calculo litros necessários
            val litrosNecessarios = distancia / consumo

            //Calculo do custo total
            val custoTotal = litrosNecessarios * precoLitro

            val intent = Intent(this, ResultadoActivity::class.java)
            intent.putExtra("PRECO_LITRO_VALOR", precoLitro)
            intent.putExtra("PRECO_LITRO_DISTANCIA", distancia)
            intent.putExtra("PRECO_LITRO_CONSUMO", consumo)
            intent.putExtra("PRECO_LITRO_CUSTO_TOTAL", custoTotal)

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