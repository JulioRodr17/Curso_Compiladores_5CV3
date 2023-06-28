package org.Compiladores.Kotlin

import java.util.*

class GeneradorPostfija internal constructor(private var infija: List<Token>) {


    private lateinit var pila: Stack<Token>
    private lateinit var postfija: MutableList<Token>

    init {
        this.infija = infija
        pila = Stack()
        postfija = ArrayList()
    }

    fun convertir(): List<Token> {
        var estructuraDeControl = false
        val pilaEstructurasDeControl = Stack<Token>()
        for (i in infija.indices) {
            val t = infija[i]
            if (t.tipo == TokenType.EOF) {
                break
            }
            if (t.esPalabraReservada()) {
                /*
                 Si el token actual es una palabra reservada, se va directo a la
                 lista de salida.
                 */
                postfija.add(t)
                if (t.esEstructuraDeControl()) {
                    estructuraDeControl = true
                    pilaEstructurasDeControl.push(t)
                }
            } else if (t.esOperando()) {
                postfija.add(t)
            } else if (t.tipo == TokenType.LEFT_PAREN) {
                pila.push(t)
            } else if (t.tipo == TokenType.RIGHT_BRACE) {
                while (!pila.isEmpty() && pila.peek().tipo !== TokenType.LEFT_PAREN) {
                    val temp = pila.pop()
                    postfija.add(temp)
                }
                if (pila.peek().tipo == TokenType.LEFT_PAREN) {
                    pila.pop()
                }

                // Esta sección de aquí es para manejar el ")" que cierra la
                // condición de la estructura de control
                if (estructuraDeControl && infija[i + 1].tipo == TokenType.LEFT_BRACE) {
                    postfija.add(Token(TokenType.SEMICOLON, ";", null))
                }
            } else if (t.esOperador()) {
                while (!pila.isEmpty() && pila.peek().precedenciaMayorIgual(t)) {
                    val temp = pila.pop()
                    postfija.add(temp)
                }
                pila.push(t)
            } else if (t.tipo == TokenType.SEMICOLON) {
                while (!pila.isEmpty() && pila.peek().tipo != TokenType.LEFT_BRACE) {
                    val temp = pila.pop()
                    postfija.add(temp)
                }
                postfija.add(t)
            } else if (t.tipo ==TokenType.LEFT_BRACE) {
                // Se mete a la pila, tal como el parentesis. Este paso
                // pudiera omitirse, sólo hay que tener cuidado en el manejo
                // del "}".
                pila.push(t)
            } else if (t.tipo == TokenType.RIGHT_BRACE && estructuraDeControl) {

                // Primero verificar si hay un else:
                if (infija[i + 1].tipo == TokenType.ELSE) {
                    // Sacar el "{" de la pila
                    pila.pop()
                } else {
                    // En este punto, en la pila sólo hay un token: "{"
                    // El cual se extrae y se añade un ";" a cadena postfija,
                    // El cual servirá para indicar que se finaliza la estructura
                    // de control.
                    pila.pop()
                    postfija.add(Token(TokenType.SEMICOLON, ";", null))

                    // Se extrae de la pila de estrucuras de control, el elemento en el tope
                    val aux = pilaEstructurasDeControl.pop()

                    /*
                        Si se da este caso, es necesario extraer el IF de la pila
                        pilaEstructurasDeControl, y agregar los ";" correspondientes
                     */if (aux.tipo == TokenType.ELSE) {
                        pilaEstructurasDeControl.pop()
                        postfija.add(Token(TokenType.SEMICOLON, ";", null))
                    }
                    if (pilaEstructurasDeControl.isEmpty()) {
                        estructuraDeControl = false
                    }
                }
            }
        }
        while (!pila.isEmpty()) {
            val temp = pila.pop()
            postfija.add(temp)
        }
        while (!pilaEstructurasDeControl.isEmpty()) {
            pilaEstructurasDeControl.pop()
            postfija.add(Token(TokenType.SEMICOLON, ";", null))
        }
        return postfija
    }

}