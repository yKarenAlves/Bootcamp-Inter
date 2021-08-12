package com.example.imcapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private var altura: EditText? = null
    private var peso: EditText? = null
    private var titleText: TextView? = null
    private var botao: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        altura = findViewById(R.id.alturaEDT)
        peso = findViewById(R.id.pesoEDT)
        titleText = findViewById(R.id.titleTXT)
        botao = findViewById(R.id.calcularBTN)

        botao?.setOnClickListener {
            calcularIMC(peso?.text.toString(), altura?.text.toString())
        }
    }

    private fun calcularIMC(peso: String, altura: String) {
        val peso = peso.toFloatOrNull()
        val altura = altura.toFloatOrNull()

        if (peso != null && altura != null) {
            val imc = peso / (altura * altura)

            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("imc", imc)
            startActivity(intent)
        }
    }
}


