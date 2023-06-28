package org.Compiladores.Kotlin

import java.util.*

class GeneradorAST internal constructor(private var postfija: List<Token>) {


    private lateinit var pila: Stack<Nodo>


    init {
        this.postfija = postfija
        pila = Stack()
    }

    fun generarAST(): Arbol {
        val pilaPadres = Stack<Nodo>()

        val raiz : Nodo = Nodo(null)
        pilaPadres.push(raiz)
        var padre = raiz
        for (t: Token in postfija) {
            if (t.tipo == TokenType.EOF) {
                break
            }
            if (t.esPalabraReservada()) {
                val n = Nodo(t)
                padre = pilaPadres.peek()
                padre.insertarSiguienteHijo(n)
                pilaPadres.push(n)
                padre = n
            } else if (t.esOperando()) {
                val n = Nodo(t)
                pila.push(n)
            } else if (t.esOperador()) {
                val aridad = t.aridad()
                val n = Nodo(t)
                for (i in 1..aridad) {
                    val nodoAux = pila.pop()
                    n.insertarHijo(nodoAux)
                }
                pila.push(n)
            } else if (t.tipo == TokenType.SEMICOLON) {
                if (pila.isEmpty()) {
                    /*
                    Si la pila esta vacía es porque t es un punto y coma
                    que cierra una estructura de control
                     */
                    pilaPadres.pop()
                    padre = pilaPadres.peek()
                } else {
                    val n = pila.pop()
                    if (padre.getValue().tipo == TokenType.VAR) {
                        /*
                        En el caso del VAR, es necesario eliminar el igual que
                        pudiera aparecer en la raíz del nodo n.
                         */
                        if (n.getValue().tipo == TokenType.EQUAL) {
                            padre.insertarHijos(n.getHijos())
                        } else {
                            padre.insertarSiguienteHijo(n)
                        }
                        pilaPadres.pop()
                        padre = pilaPadres.peek()
                    } else if (padre.getValue().tipo == TokenType.PRINT) {
                        padre.insertarSiguienteHijo(n)
                        pilaPadres.pop()
                        padre = pilaPadres.peek()
                    } else {
                        padre.insertarSiguienteHijo(n)
                    }
                }
            }
        }

        // Suponiendo que en la pila sólamente queda un nodo
        // Nodo nodoAux = pila.pop();
        return Arbol(raiz)
    }
}