package org.Compiladores

import org.Compiladores.Ttoken
import org.omg.CORBA.Object


class Token() {

    constructor(tipo: Ttoken, lexema: String, literal: Object?, linea: Int): this(){
        this.tipo = tipo
        this.lexema = lexema
        this.literal = literal
        this.linea = linea
    }

    final var tipo: Ttoken = Ttoken.EOF
    final var lexema: String = ""
    final var literal: Object? = null
    final var linea: Int = 0

    // constructor(tipo:Ttoken, lexema:String, literal:Object){
      //  println("$tipo $lexema $literal")
    //  }
    /*init{
        this.tipo = tipo
        this.lexema = lexema 
        this.literal = literal 
        this.linea = linea
    }*/


    override fun toString(): String{
        return "Tipo: $tipo Lexema: $lexema Literal: $literal Linea: $linea"
    }

    fun holaMundo():String{
        return "Hola mundo"
    }



}

//fun String?.plus(other: Any?): String