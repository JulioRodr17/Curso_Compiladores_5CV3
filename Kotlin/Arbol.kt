package org.Compiladores.Kotlin

class Arbol internal constructor(private var raiz: Nodo)  {


    fun recorrer() {
        for ( n: Nodo in raiz.getHijos()) {
            val t: Token = n.getValue()

            when (t.tipo) {
                 TokenType.PLUS,TokenType.MINUS, TokenType.MULTIPLY, TokenType.DIVIDE-> {
                    var solver: SolverAritmetico = SolverAritmetico(n)
                    val res: Any? = solver.resolver()
                    println(res)

                }

                TokenType.VAR -> {}
                TokenType.IF -> {}

                else ->{}
            }
        }
    }

}