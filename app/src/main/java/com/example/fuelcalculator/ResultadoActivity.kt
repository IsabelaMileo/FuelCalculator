package com.example.fuelcalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Locale

class ResultadoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_resultado)

        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                finishAffinity()
            }
        })

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }



        val custoTotal = intent.getDoubleExtra("PRECO_LITRO_CUSTO_TOTAL", 0.0)
        val distanciaTotal = intent.getDoubleExtra("PRECO_LITRO_DISTANCIA", 0.0)
        val consumoLitro = intent.getDoubleExtra(

            "PRECO_LITRO_CONSUMO", 0.0)
        val precoPorLitro = intent.getDoubleExtra("PRECO_LITRO_VALOR", 0.0)

        val tvCusto = findViewById<TextView>(R.id.tvCustoViagem)
        val tvDistanciaValor = findViewById<TextView>(R.id.tvDistanciaResultado)
        val tvConsumoValor = findViewById<TextView>(R.id.tvConsumoResultado)
        val tvPrecoLitroValor = findViewById<TextView>(R.id.tvPrecoResultado)
        val btnNovoResultado = findViewById<Button>(R.id.btnNovoResultado)


// Formata o custo total no padrão brasileiro (R$)
        val custoFormatado = String.format(Locale("pt", "BR"), "R$ %,.2f", custoTotal)
        tvCusto.text = custoFormatado

// Adiciona as unidades para ficar bem intuitivo para o usuário
        tvDistanciaValor.text = "$distanciaTotal km"
        tvConsumoValor.text = "$consumoLitro km/l"
        tvPrecoLitroValor.text = String.format(Locale("pt", "BR"), "R$ %,.2f", precoPorLitro)

        btnNovoResultado.setOnClickListener {
            val intent = Intent (this, DistanciaActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            }
            startActivity(intent)
            finish()
        }

    }
}
