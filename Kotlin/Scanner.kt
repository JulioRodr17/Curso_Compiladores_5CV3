package org.Compiladores

import org.Compiladores.main
import org.Compiladores.Ttoken
import java.util.ArrayList


class Scanner{
    private final var source: String = ""
    public var tope: StringBuilder = StringBuilder()

    private final var tokens:  List<Token> = ArrayList()


    private var linea: Int = 1


   private final var palabrasReservadas = hashMapOf<String, Ttoken>()

    init {
        palabrasReservadas.put("false",Ttoken.FALSE )
        palabrasReservadas.put("for",Ttoken.FOR )
        palabrasReservadas.put("fun",Ttoken.FUN ) //definir funciones
        palabrasReservadas.put("if",Ttoken.IF )
        palabrasReservadas.put("null",Ttoken.NULL )
        palabrasReservadas.put("else", Ttoken.ELSE )
        palabrasReservadas.put("print",Ttoken.PRINT)
        palabrasReservadas.put("return",Ttoken.RETURN)
        palabrasReservadas.put("super", Ttoken.SUPER )
        palabrasReservadas.put("this",Ttoken.THIS)
        palabrasReservadas.put("true",Ttoken.TRUE)
        palabrasReservadas.put("while",Ttoken.WHILE)
        palabrasReservadas.put("clase",Ttoken.CLASE)
        palabrasReservadas.put("id",Ttoken.ID)

        palabrasReservadas.put("(", Ttoken.IZ_PAR)
        palabrasReservadas.put(")", Ttoken.DER_PAR)
        palabrasReservadas.put("{", Ttoken.IZ_LLAVE)
        palabrasReservadas.put("}", Ttoken.DER_LLAVE)
        palabrasReservadas.put(",", Ttoken.COMA)
        palabrasReservadas.put(".", Ttoken.PUNTO)
        palabrasReservadas.put(";", Ttoken.PUNTO_COMA)
        palabrasReservadas.put("-", Ttoken.MENOS)
        palabrasReservadas.put("+", Ttoken.MAS)
        palabrasReservadas.put("*", Ttoken.MULTIPLICA)
        palabrasReservadas.put("/", Ttoken.DIVIDE)
        palabrasReservadas.put("!", Ttoken.INV) //exclusivo para casos de tipo bool
        palabrasReservadas.put("!=", Ttoken.NO_IGUAL)
        palabrasReservadas.put("=", Ttoken.ASIGNAR)//=
        palabrasReservadas.put("==", Ttoken.IGUAL)//==
        palabrasReservadas.put("<", Ttoken.MENOR)
        palabrasReservadas.put("<=", Ttoken.MENOR_IGUAL)
        palabrasReservadas.put(">", Ttoken.MAYOR)
        palabrasReservadas.put(">=", Ttoken.MAYOR_IGUAL)
        palabrasReservadas.put("&&", Ttoken.AND)
        palabrasReservadas.put("||", Ttoken.OR)

    }

    constructor(source: String){
        this.source = source

    }


    fun scanTokens(): List<Token>{
        tokens += listOf(Token(Ttoken.EOF, " ", null, linea))
        return tokens
    }







}


