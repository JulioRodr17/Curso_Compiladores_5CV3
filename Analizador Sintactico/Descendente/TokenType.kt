package org.Compiladores.Descendente
enum class TokenType {
    // Identificadores
    IDENTIFIER,

    // Palabaras reservadas
    SELECT,
    FROM,
    DISTINCT,

    // Carácteres
    COMMA,
    DOT,
    ASTERISK,
    EPSILON,

    // Final de cadena
    EOF,
}