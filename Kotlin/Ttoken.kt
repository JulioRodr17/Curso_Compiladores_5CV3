package org.Compiladores



enum class Ttoken{

    // Crear un tipoToken por palabra reservada
    // Crear un tipoToken: identificador, una cadena y numero
    ID, CAD, NUM, VAR, LETRA,
    // Crear un tipoToken por cada "Signo del lenguaje" (ver clase Scanner)
    IZ_PAR, DER_PAR, IZ_LLAVE, DER_LLAVE, COMA, PUNTO, PUNTO_COMA, MENOS, MAS, MULTIPLICA, DIVIDE,
    INV,NO_IGUAL,ASIGNAR,IGUAL,MENOR,MENOR_IGUAL,MAYOR,MAYOR_IGUAL,

    // Palabras Reservadas
    ELSE, FOR, FUN, IF, NULL, PRINT, RETURN, SUPER, THIS, TRUE, FALSE, WHILE,
    // Palabras clave:
    AND, OR, CLASE,

    // Final de cadena
    EOF
   
}