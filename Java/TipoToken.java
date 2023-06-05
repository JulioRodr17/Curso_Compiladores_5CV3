package org.Compiladores.Java;

public enum TipoToken {
    // Crear un tipoToken por palabra reservada
    IDENTIFICADOR,
    // Crear un tipoToken: identificador, una cadena y numero
    ID, CAD, NUM, VAR, LETRA,
    // Crear un tipoToken por cada "Signo del lenguaje" (ver clase Scanner)
    IZ_PAR, DER_PAR, IZ_LLAVE, DER_LLAVE, IZ_CORCH, DER_CORCH, COMA, PUNTO, PUNTO_COMA, MENOS, MAS, MULTIPLICA, DIVIDE, MODULO,
    INV,NO_IGUAL,ASIGNAR,IGUAL,MENOR,MENOR_IGUAL,MAYOR,MAYOR_IGUAL,MAS_IGUAL,MENOS_IGUAL,POR_IGUAL,ENTRE_IGUAL,MOD_IGUAL,

    // Palabras Reservadas
    ELSE, FOR, FUN, IF, NULL, PRINT, RETURN, SUPER, THIS, TRUE, FALSE, WHILE,
    // Palabras clave:
    AND, OR, CLASE, NOT,

    // Final de cadena
    EOF
}
