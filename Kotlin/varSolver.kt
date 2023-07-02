package org.Compiladores.Kotlin

class varSolver(private var nodo: Nodo) {


    fun registrar(){
        sol(nodo)
    }

    fun sol(n: Nodo){


        val aritmeticosolver: SolverAritmetico


       val registrarVarIzq: Nodo? = n.getHijos()?.get(0)
       val registrarVarDer = if(n.getHijos()?.size!! > 1){n.getHijos()?.get(1)}else{null}

       aritmeticosolver = SolverAritmetico(registrarVarDer!!)

       val izq: String = registrarVarIzq!!.getValue().lexema
       val der: Any? = registrarVarDer == aritmeticosolver.resolver()

       var tabladeSimbolos = TabladeSimbolos

        tabladeSimbolos.addVariable(izq, der)


    }



}