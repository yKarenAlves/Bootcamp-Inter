package com.example.imcapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class ResultActivity : AppCompatActivity() {

    private var botaoVoltar: Button? = null
    private var textResultado: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        botaoVoltar = findViewById(R.id.buttonVoltar)
        textResultado = findViewById(R.id.textResultado)

        val imc = intent.getFloatExtra("imc",0.0f)
        var classificacao = ""
        when (imc)    {
            in 0.0..18.5 -> classificacao = "Peso baixo"
            in 18.5..24.9 -> classificacao = "Peso normal"
            in 25.0..29.9 -> classificacao = "Sobrepeso"
            in 30.0..34.9 -> classificacao = "Obesidade (GRAU I)"
            in 35.0..39.9 -> classificacao = "Obesidade Severa (GRAU II)"
            else -> classificacao = "Obesidade Mórbida (GRAU III)"
        }

        textResultado?.text = "Seu IMC é: ${"%.1f".format(imc)}\n${classificacao}"

        botaoVoltar?.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}