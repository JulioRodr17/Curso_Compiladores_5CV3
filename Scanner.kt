package org.Compiladores

import org.Compiladores.Ttoken
import java.util.ArrayList

class Scanner{
    private final var source: String = ""

    private final var tokens:  List<Token> = ArrayList()


    private var linea: Int = 1


   private final var palabrasReservadas = hashMapOf<String, Ttoken>()

    init {
        palabrasReservadas.put("y", Ttoken.Y)
        palabrasReservadas.put("clase", Ttoken.CLASE)
        palabrasReservadas.put("id", Ttoken.ID)
        palabrasReservadas.put("cadena", Ttoken.CAD)
        palabrasReservadas.put("numero", Ttoken.NUM)
        palabrasReservadas.put("parentIzq", Ttoken.IZ_PAR)
        palabrasReservadas.put("parentDer", Ttoken.DER_PAR)
        palabrasReservadas.put("llaveIzq", Ttoken.IZ_LLAVE)
        palabrasReservadas.put("llaveDer", Ttoken.DER_LLAVE)
        palabrasReservadas.put("coma", Ttoken.COMA)
        palabrasReservadas.put("punto", Ttoken.PUNTO)
        palabrasReservadas.put("puntoComa", Ttoken.PUNTO_COMA)
        palabrasReservadas.put("menos", Ttoken.MENOS)
        palabrasReservadas.put("mas", Ttoken.MAS)
        palabrasReservadas.put("multiplica", Ttoken.MULTIPLICA)
        palabrasReservadas.put("divide", Ttoken.DIVIDE)
        palabrasReservadas.put("inverso", Ttoken.INV) //exclusivo para casos de tipo bool
        palabrasReservadas.put("noIgual", Ttoken.NO_IGUAL)
        palabrasReservadas.put("asignar", Ttoken.ASIGNAR)//=
        palabrasReservadas.put("igual", Ttoken.IGUAL)//==
        palabrasReservadas.put("menor", Ttoken.MENOR)
        palabrasReservadas.put("menorIgual", Ttoken.MENOR_IGUAL)
        palabrasReservadas.put("mayor", Ttoken.MAYOR)
        palabrasReservadas.put("mayorIgual", Ttoken.MAYOR_IGUAL)
        palabrasReservadas.put("comentLinea", Ttoken.CMNTRIO_LINEA)
        palabrasReservadas.put("comentParrafo", Ttoken.CMNTRIO_PARRAFO)
    }

    constructor(source: String){
        this.source = source
    }

    fun scanTokens(): List<Token>{

     //   tokens.add(Token(Ttoken.EOF,"",null, linea))
        return tokens
    }







}


