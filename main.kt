package org.Compiladores


import java.util.Scanner
import org.Compiladores.Ttoken
import org.Compiladores.Token

const val error: Boolean = false

fun main(){
    var tipo: Ttoken = Ttoken.EOF
    var dattt = Token(tipo, "", {}, 0)
    println("$dattt")
}