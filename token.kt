package org.Compiladores

import org.Compiladores.Ttoken


data class Token (var tipo: Ttoken,var lexema: String, var literal: Object, var linea: Int)