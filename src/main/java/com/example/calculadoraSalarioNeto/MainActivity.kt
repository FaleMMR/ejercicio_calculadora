package com.example.calculadoraSalarioNeto

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(
            findViewById(R.id.main)
        ) { v: View, insets: WindowInsetsCompat ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val calcular = findViewById<Button>(R.id.btVolver)
        calcular.setOnClickListener {
            val etsalario = findViewById<EditText>(R.id.etSslario2)
            val etedad = findViewById<EditText>(R.id.etRetencion)
            val etnumhijos = findViewById<EditText>(R.id.etNumHijos)
            val etnumpagas = findViewById<EditText>(R.id.etNeto)
            val etgrado = findViewById<EditText>(R.id.etGrado)
            val etestadocv = findViewById<EditText>(R.id.etEstadoCivil)
            val etgrupo = findViewById<EditText>(R.id.etDeducciones)

            val salario = etsalario.text.toString().toInt()
            val edad = etedad.text.toString().toInt()
            val numhijos = etnumhijos.text.toString().toInt()
            val numpagas = etnumpagas.text.toString().toInt()
            val grado = etgrado.text.toString()
            val grupo = etgrupo.text.toString()
            val estadocv = etestadocv.text.toString()

            val d = Datos(salario, edad, numhijos, numpagas, grado, grupo, estadocv)

            val i = Intent(this@MainActivity, SegundaActivity::class.java)
            i.putExtra("datos", d)
            startActivity(i)
        }
    }
}