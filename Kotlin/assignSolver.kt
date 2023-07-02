package org.Compiladores.Kotlin

class assignSolver(private var nodo: Nodo){

    fun asignar() {
        solve(nodo)
    }

    private fun solve(n: Nodo) {
        val tabladeSimbolos = TabladeSimbolos
        val arithmeticSolver: SolverAritmetico
        var arbol: Arbol

        val hijo: MutableList<Nodo>? = n.getHijos()
        val variable = hijo?.get(0)
        val value = hijo?.get(1)
        arithmeticSolver = SolverAritmetico(value!!)
        val valueResult: Any? = arithmeticSolver.resolver()
        tabladeSimbolos.setValor(variable!!.getValue().lexema, valueResult)
    }
}