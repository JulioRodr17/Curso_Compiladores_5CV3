package org.Compiladores.Kotlin

class Nodo() {

    private var value: Token = Token( null)
    private lateinit var hijos: MutableList<Nodo>


    constructor(value: Token?): this(){
        this.value = value!! //duda :(
    }


    fun insertarHijo(n: Nodo) {
        if (hijos == null) {
            hijos = ArrayList()
            hijos.add(n)
        } else {
            hijos.add(0, n)
        }
    }

    fun insertarSiguienteHijo(n: Nodo) {
        if (hijos == null) {
            hijos = ArrayList()
            hijos.add(n)
        } else {
            hijos.add(n)
        }
    }

    fun insertarHijos(nodosHijos: List<Nodo>) {
        if (hijos == null) {
            hijos = ArrayList()
        }
        for (n in nodosHijos) {
            hijos.add(n)
        }
    }



    fun getValue(): Token {
        return value
    }

    fun getHijos(): List<Nodo> {
        return hijos
    }
}