package com.example.calculadoraSalarioNeto

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SegundaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.enableEdgeToEdge()
        setContentView(R.layout.activity_segunda)
        ViewCompat.setOnApplyWindowInsetsListener(
            findViewById(R.id.main)
        ) { v: View, insets: WindowInsetsCompat ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var tipoIRPF = 0.0
        var deducciones = 0.0
        val i = intent

        val d = i.getSerializableExtra("datos") as Datos?

        tipoIRPF = if (d!!.salario > 0 && d.salario < 12449) {
            19.0
        } else if (d.salario > 12450 && d.salario < 20199) {
            12.0
        } else if (d.salario > 20200 && d.salario < 35199) {
            30.0
        } else if (d.salario > 35200 && d.salario < 59999) {
            37.0
        } else if (d.salario > 60000 && d.salario < 300000) {
            45.0
        } else {
            47.0
        }

        if (d.numhijos == 1 && d.salario <= 17644) {
            tipoIRPF = 0.0
            deducciones = 19.0
        }

        if (d.numhijos > 1 && d.salario <= 18694) {
            tipoIRPF = 0.0
            deducciones = 22.0
        }

        val etsalario = findViewById<EditText>(R.id.etSslario2)
        val etNeto = findViewById<EditText>(R.id.etNeto)
        val etRetencion = findViewById<EditText>(R.id.etRetencion)
        val etDeducciones = findViewById<EditText>(R.id.etDeducciones)

        val retencion = d.salario / 100 * tipoIRPF
        val neto = d.salario - retencion
        val deducido = d.salario / 100 * deducciones

        etsalario.setText(d.salario.toString() + "")
        etNeto.setText(neto.toString() + "")
        etRetencion.setText(retencion.toString() + "")
        etDeducciones.setText(deducido.toString() + "")

        val botonvolver = findViewById<Button>(R.id.btVolver)
        botonvolver.setOnClickListener { finish() }
    }
}