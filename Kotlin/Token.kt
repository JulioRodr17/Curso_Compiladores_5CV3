package org.Compiladores.Kotlin


class Token(){

    constructor(tipo: TokenType, lexema: String, literal: Any?, linea: Int): this(){
        this.tipo = tipo
        this.lexema = lexema
        this.literal = literal
        this.linea = linea
    }

    constructor(tipo: TokenType, lexema: String): this(){
        this.tipo = tipo
        this.lexema = lexema
        this.literal = null
        this.linea = 0
    }

    final var tipo: TokenType = TokenType.EOF
    final var lexema: String = ""
    final var literal: Any? = null
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
        return "${tipo.name + lexema + literal}"
    }

    override fun equals(other: Any?):Boolean{
        if(other !is Token){
            return false
        }

        return this.tipo == other.tipo

    }


    override fun hashCode(): Int {
        var result = tipo.hashCode()
        result = 31 * result + lexema.hashCode()
        result = 31 * result + literal.hashCode()
        result = 31 * result + linea
        return result
    }

    fun holaMundo():String{
        return "Hola mundo"
    }

   

}

//fun String?.plus(other: Any?): String