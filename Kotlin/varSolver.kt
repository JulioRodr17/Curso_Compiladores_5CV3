package org.Compiladores.Kotlin

class varSolver(private var nodo: Nodo) {


    fun registrar(){
        sol(nodo)
    }

    fun sol(n: Nodo){

        var tabladeSimbolos = TabladeSimbolos
        //println("tabladeSimbolos ${tabladeSimbolos}")
        val aritmeticosolver: SolverAritmetico
        //println("aritmeticosolver ${aritmeticosolver}")

        val registrarVarIzq: Nodo? = n.getHijos()?.get(0)
        //println("registrarVarIzq ${registrarVarIzq}")

        //println("n.getHijos()?.size ${n.getHijos()?.size}")
        val hijosSize = if(n.getHijos()?.size != null) n.getHijos()?.size else 0
        val registrarVarDer: Nodo? = if(hijosSize!! > 1) {n.getHijos()?.get(1)} else {null}
        //println("registrarVarDer ${registrarVarDer}")

        aritmeticosolver = SolverAritmetico(registrarVarDer!!)

        val izq: String = registrarVarIzq!!.getValue().lexema
        //println("izq ${izq}")
        val der: Any? = registrarVarDer == aritmeticosolver.resolver()
        println("der: ${der}")


        tabladeSimbolos.addVariable(izq, der)



        println("der: ${der}")


    }



}