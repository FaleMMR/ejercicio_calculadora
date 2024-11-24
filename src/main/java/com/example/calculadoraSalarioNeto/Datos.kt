package com.example.calculadoraSalarioNeto

import java.io.Serializable

class Datos : Serializable {
    var salario: Int = 0
    var edad: Int = 0
    var numhijos: Int = 0
    var numpagas: Int = 0
    var grado: String? = null
    var grupo: String? = null
    var estadocv: String? = null

    constructor()

    constructor(
        salario: Int,
        edad: Int,
        numhijos: Int,
        numpagas: Int,
        grado: String?,
        grupo: String?,
        estadocv: String?
    ) {
        this.salario = salario
        this.edad = edad
        this.numhijos = numhijos
        this.numpagas = numpagas
        this.grado = grado
        this.grupo = grupo
        this.estadocv = estadocv
    }
}
