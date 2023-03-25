package mx.ipn.escom.compiladores;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Scanner {

    private final String source;

    private final List<Token> tokens = new ArrayList<>();

    private int linea = 1;

    private static final Map<String, TipoToken> palabrasReservadas;
    static {
        palabrasReservadas = new HashMap<>();
        palabrasReservadas.put("y", TipoToken.Y);
        palabrasReservadas.put("clase", TipoToken.CLASE);
        palabrasReservadas.put("id", TipoToken.ID);
        palabrasReservadas.put("cadena", TipoToken.CAD);
        palabrasReservadas.put("numero", TipoToken.NUM);
        palabrasReservadas.put("parentIzq", TipoToken.IZ_PAR);
        palabrasReservadas.put("parentDer", TipoToken.DER_PAR);
        palabrasReservadas.put("llaveIzq", TipoToken.IZ_LLAVE);
        palabrasReservadas.put("llaveDer", TipoToken.DER_LLAVE);
        palabrasReservadas.put("coma", TipoToken.COMA);
        palabrasReservadas.put("punto", TipoToken.PUNTO);
        palabrasReservadas.put("puntoComa", TipoToken.PUNTO_COMA);
        palabrasReservadas.put("menos", TipoToken.MENOS);
        palabrasReservadas.put("mas", TipoToken.MAS);
        palabrasReservadas.put("multiplica", TipoToken.MULTIPLICA);
        palabrasReservadas.put("divide", TipoToken.DIVIDE);
        palabrasReservadas.put("inverso", TipoToken.INV); //exclusivo para casos de tipo bool
        palabrasReservadas.put("noIgual", TipoToken.NO_IGUAL);
        palabrasReservadas.put("asignar", TipoToken.ASIGNAR);//=
        palabrasReservadas.put("igual", TipoToken.IGUAL);//==
        palabrasReservadas.put("menor", TipoToken.MENOR);
        palabrasReservadas.put("menorIgual", TipoToken.MENOR_IGUAL);
        palabrasReservadas.put("mayor", TipoToken.MAYOR);
        palabrasReservadas.put("mayorIgual", TipoToken.MAYOR_IGUAL);
        palabrasReservadas.put("comentLinea", TipoToken.CMNTRIO_LINEA);
        palabrasReservadas.put("comentParrafo", TipoToken.CMNTRIO_PARRAFO);
        





    }

    Scanner(String source){
        this.source = source;
    }

    List<Token> scanTokens(){
        //Aquí va el corazón del scanner.

        /*
        Analizar el texto de entrada para extraer todos los tokens
        y al final agregar el token de fin de archivo
         */
        tokens.add(new Token(TipoToken.EOF, "", null, linea));

        return tokens;
    }
}

/*
Signos o símbolos del lenguaje:
(
)
{
}
,
.
;
-
+
*
/
!
!=
=
==
<
<=
>
>=
// -> comentarios (no se genera token)
/* ... * / -> comentarios (no se genera token)
Identificador,
Cadena
Numero
Cada palabra reservada tiene su nombre de token

 */