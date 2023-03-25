package org.Compiladores

import org.Compiladores.Ttoken


class Token(    final var tipo: Ttoken,
                final var lexema: String,
                final var literal: Object, 
                final var linea: Int ){

  
    // constructor(tipo:Ttoken, lexema:String, literal:Object){
      //  println("$tipo $lexema $literal")
    //  }
    init{
        this.tipo = tipo
        this.lexema = lexema 
        this.literal = literal 
        this.linea = linea
    }


   // fun String?.plus(other: Any?): String

}

//fun String?.plus(other: Any?): String