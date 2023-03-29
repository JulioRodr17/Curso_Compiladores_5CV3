package mx.ipn.escom.compiladores;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.lang.String;
import java.util.regex.Pattern;


public class Scanner {

    private final String source;

    private final List<Token> tokens = new ArrayList<>();

    private int linea = 1;

    private int actual;
    private int columna;

    public StringBuilder tope;

    private static final Map<String, TipoToken> palabrasReservadas;
    private static final Map<String, TipoToken> signos;

    static {
        palabrasReservadas = new HashMap<>();
        signos = new HashMap();

       // palabrasReservadas.put("cadena", TipoToken.CAD);
     //   palabrasReservadas.put("numero", TipoToken.NUM);

     //signos utilizados para la lectura de funciones u otros
        signos.put("(", TipoToken.IZ_PAR);
        signos.put(")", TipoToken.DER_PAR);
        signos.put("{", TipoToken.IZ_LLAVE);
        signos.put("}", TipoToken.DER_LLAVE);
        signos.put(",", TipoToken.COMA);
        signos.put(".", TipoToken.PUNTO);
        signos.put(";", TipoToken.PUNTO_COMA);
        signos.put("-", TipoToken.MENOS);
        signos.put("+", TipoToken.MAS);
        signos.put("*", TipoToken.MULTIPLICA);
        signos.put("/", TipoToken.DIVIDE);
        signos.put("!", TipoToken.INV); //exclusivo para casos de tipo bool
        signos.put("!=", TipoToken.NO_IGUAL);
        signos.put("=", TipoToken.ASIGNAR);//=
        signos.put("==", TipoToken.IGUAL);//==
        signos.put("<", TipoToken.MENOR);
        signos.put("<=", TipoToken.MENOR_IGUAL);
        signos.put(">", TipoToken.MAYOR);
        signos.put(">=", TipoToken.MAYOR_IGUAL);


        //palabras reservadas que ayudan a la lectura
        palabrasReservadas.put("false", TipoToken.FALSE );
        palabrasReservadas.put("for", TipoToken.FOR );
        palabrasReservadas.put("fun", TipoToken.FUN ); //definir funciones
        palabrasReservadas.put("if", TipoToken.IF );
        palabrasReservadas.put("null", TipoToken.NULL );
        palabrasReservadas.put("else",TipoToken.ELSE );
        palabrasReservadas.put("print", TipoToken.PRINT);
        palabrasReservadas.put("return", TipoToken.RETURN);
        palabrasReservadas.put("super",TipoToken.SUPER );
        palabrasReservadas.put("this", TipoToken.THIS);
        palabrasReservadas.put("true", TipoToken.TRUE);
        palabrasReservadas.put("while", TipoToken.WHILE);
        palabrasReservadas.put("y", TipoToken.Y);
        palabrasReservadas.put("clase", TipoToken.CLASE);
        palabrasReservadas.put("id", TipoToken.ID);

    }

    Scanner(String source){
        this.source = source;
        this.tope = new StringBuilder();
    }

    List<Token> scanTokens(){


        int num = 1;
        int estado = 0;

        for(int i = 0; i <= this.source.length() ; i++ ) {

        char c = (i == this.source.length()) ? '\0' : this.source.charAt(i);

        num = c == '\n' ? ++num :num;

            switch (estado){
                case 0:

                    break;
                case 10:

                    break;

                default:

                    break;
            }








        }


        tokens.add(new Token(TipoToken.EOF, "", null, linea));

        return tokens;
    }


    private boolean transición(char c, String r){
        return Pattern.compile(r).matcher(String.valueOf(c)).matches();
    }

        


   
    }

