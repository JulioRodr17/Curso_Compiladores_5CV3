package mx.ipn.escom.compiladores;

public enum TipoToken {
    // Crear un tipoToken por palabra reservada
    // Crear un tipoToken: identificador, una cadena y numero
    ID, CAD, NUM,
    // Crear un tipoToken por cada "Signo del lenguaje" (ver clase Scanner)
    IZ_PAR, DER_PAR, IZ_LLAVE, DER_LLAVE, COMA, PUNTO, PUNTO_COMA, MENOS, MAS, MULTIPLICA, DIVIDE,
    INV,NO_IGUAL,ASIGNAR,IGUAL,MENOR,MENOR_IGUAL,MAYOR,MAYOR_IGUAL,CMNTRIO_LINEA,CMNTRIO_PARRAFO,
    // Palabras clave:
    Y, CLASE,

    // Final de cadena
    EOF
}
