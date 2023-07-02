package org.Compiladores.Kotlin

class Arbol (private var raiz: Nodo) {


    fun recorrer() {
        for (n in raiz.getHijos()!!) {
            val t: Token = n.getValue()

            when (t.tipo) {
                TokenType.PLUS, TokenType.MINUS, TokenType.MULTIPLY, TokenType.DIVIDE, TokenType.LESS,
                TokenType.GREATER, TokenType.LESS_EQUAL, TokenType.GREATER_EQUAL, TokenType.EQUAL,
                TokenType.NOT_EQUAL, TokenType.AND, TokenType.OR -> {
                    var solver: SolverAritmetico = SolverAritmetico(n)
                    val res: Any? = solver.resolver()
                    println(res)

                }

                TokenType.ASSIGN -> {
                    var assignsolver = assignSolver(n)
                    val res: Any? = assignsolver.asignar()
                }
                TokenType.VAR -> {
                    var varsolver = varSolver(n)
                    val res: Any? = varsolver.registrar()

                }
                TokenType.IF -> {
                    var ifsolver = ifSolver(n)
                    val res: Any? = ifsolver.resolver()
                    println(res)
                }

                TokenType.PRINT ->{
                    var printsolver = printSolver(n)
                    println(printsolver.imprimir())
                }


                else ->{}

            }
        }
    }
}