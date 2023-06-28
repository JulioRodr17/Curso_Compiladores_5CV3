package org.Compiladores.Kotlin

class SolverAritmetico internal constructor(private var nodo: Nodo) {




    fun resolver(): Any? {
        return resolver(nodo)
    }

    private fun resolver(n: Nodo): Any? {
        // No tiene hijos, es un operando
        if (n.getHijos() == null) {
            if (n.getValue().tipo === TokenType.NUMBER|| n.getValue().tipo === TokenType.STRING) {
                return n.getValue().literal
            }
            else if (n.getValue().tipo === TokenType.IDENTIFIER) {
                // Ver la tabla de símbolos
            }

        }

        // Por simplicidad se asume que la lista de hijos del nodo tiene dos elementos
        val izq: Nodo = n.getHijos()[0]
        val der: Nodo = n.getHijos()[1]


        val resultadoIzquierdo: Any? = resolver(izq)
        val resultadoDerecho: Any? = resolver(der)

        if (resultadoIzquierdo is Double && resultadoDerecho is Double) {
            when (n.getValue().tipo) {
                TokenType.PLUS -> return resultadoIzquierdo + resultadoDerecho
                TokenType.MINUS-> return resultadoIzquierdo - resultadoDerecho
                TokenType.MULTIPLY-> return resultadoIzquierdo * resultadoDerecho
                TokenType.DIVIDE -> return resultadoIzquierdo / resultadoDerecho
                else -> {}
            }
        } else if (resultadoIzquierdo is String && resultadoDerecho is String) {
            if (n.getValue().tipo === TokenType.PLUS) {
                // Ejecutar la concatenación
            }
        } else {
            // Error por diferencia de tipos
        }
        return null
    }
}