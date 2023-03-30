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
    private int num = 1;

    public StringBuilder tope;

    private static final Map<String, TipoToken> palabrasReservadas;
    private static final Map<String, TipoToken> signos;

    static {
        palabrasReservadas = new HashMap<>();
        signos = new HashMap<>();

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
        signos.put("&&", TipoToken.AND);
        signos.put("||", TipoToken.OR);

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
        palabrasReservadas.put("clase", TipoToken.CLASE);
        palabrasReservadas.put("id", TipoToken.ID);
    }

    Scanner(String source){
        this.source = source;
        this.tope = new StringBuilder();
    }

    List<Token> scanTokens(){

        int estado = 0;

        for(int i = 0; i <= this.source.length() ; i++ ) {

            char c = (i == this.source.length()) ? '\0' : this.source.charAt(i);

            num = c == '\n' ? ++num : num;

            switch (estado){
                case 0:
                    //agregar todos los casos para realizar las asignaciones en el autómata

                    if( c == '<'){
                        estado = 1;
                        tope.append(c);
                }
                    else if(c == '='){
                        estado = 4;
                        tope.append(c);
                }
                    else if(c == '>'){
                        estado = 7;
                        tope.append(c);
                }
                    else if(c == '!'){
                        estado = 10;
                        tope.append(c);
                }
                    else if(c == "\\+"){
                        estado = 30;
                        tope.append(c);
                }
                    else if(c == '-'){
                        estado = 33;
                        tope.append(c);
                }
                    else if(c == "\\*"){
                        estado = 35;
                        tope.append(c);
                }
                    else if(c == "\\|"){
                        estado = 40;
                        tope.append(c);
                }
                    else if(c == "\\&"){
                        estado = 43;
                        tope.append(c);
                }
                    else if(c == "\\("){
                        estado = 18;
                        tope.append(c);
                }
                    else if(c == "\\)"){
                        estado = 18;
                        tope.append(c);
                }
                    else if(c == "\\{"){
                        estado = 18;
                        tope.append(c);
                }
                    else if(c == "\\}"){
                        estado = 18;
                        tope.append(c);
                }
                    else if(c == "[0-9]"){
                        estado = 22;
                        tope.append(c);
                }
                    else if(c == "[a-zA-Z]"){
                        estado = 26;
                        tope.append(c);
                }
                    else if(c == '.'){
                        estado = 24;
                        tope.append(c);
                } /*else if(c== "\\/"){
                        estado = 28;
                        tope.append(c);
                }
                    else if(c == "\\/"){
                        estado = 38;
                        tope.append(c);
                    }*/
                break;
                case 1:
                    if( c == '='){
                        estado = 2;
                        tope.append(c);
                }
                    else{
                        estado = 0;
                        i = i-1;
                        agregarToken(tope.toString());
                    }
                break;
                case 2:
                    estado = 0;
                    i--;
                    agregarToken(tope.toString());
                    break;

                case 3:
                    break;

                case 4:
                    if( c == '='){
                        estado = 6;
                        tope.append(c);
                }
                    else{
                        estado = 0;
                        i--;
                        agregarToken(tope.toString());
                    }
                    break;

                case 5:
                    break;

                case 6:
                    estado = 0;
                    i--;
                    agregarToken(tope.toString());
                    break;

                case 7:
                    if( c == '='){
                        estado = 8;
                        tope.append(c);
                }
                    else{
                        estado = 0;
                        i--;
                        agregarToken(tope.toString());
                }
                break;

                case 8:
                    estado = 0;
                    i--;
                    agregarToken(tope.toString());
                    break;

                case 9:
                    break;

                case 10:
                    if( c == '='){
                        estado = 11;
                        tope.append(c);
                }
                    else{
                        estado = 0;
                        i--;
                        agregarToken(tope.toString());
                }
                    break;

                case 11:
                    estado = 0;
                    i--;
                    agregarToken(tope.toString());
                    break;
                case 20:
                    if( c == '='){
                        estado = 21;
                        tope.append(c);
                }
                    else{
                        estado = 0;
                        i--;
                        agregarToken(tope.toString());
                    }
                break;

                case 22:
                    if(c == "[0-9]"){
                        tope.append(c);
                    }
                    else if (c=='.'){

                    }else if(c == 'E'){

                    }
                    else{
                        estado = 0;
                        i--;
                        //agregarToken(tope.toString(), TipoToken.NUM);
                        tokens.add(new Token(TipoToken.NUM, tope.toString(), new Double(tope.toString()), num));
                        tope.delete(0, tope.length());
                    }
                    //if( c == '='){
                    if( c == '='){
                        estado = 23;
                        tope.append(c);
                    }
                    else{
                        estado = 0;
                        i--;
                        agregarToken(tope.toString(), TipoToken.NUM);
                    }
                break;

                case 23:
                break;

                case 24:
                    if( c == '='){
                        estado = 25;
                        tope.append(c);
                }
                    else{
                        estado = 0;
                        i--;
                        agregarToken(tope.toString(), TipoToken.ID);
                    }
                break;

                case 26:
                    if(c == "[a-zA-Z]" || c == "[0-9]"){
                        //estado = 26
                        tope.append(c);
                    }else{
                        estado = 0;
                        TipoToken tt = palabrasReservadas.get(tope.toString());
                        if(tt == null){
                            tokens.add(new Token(TipoToken.ID, tope.toString(), null, num));
                        }
                        else{
                            tokens.add(new Token(tt, tope.toString(), null, num));
                        }
                        i--;
                        tope.delete(0, tope.length());
                    }

                    /*if( c == '='){
                        estado = 27;
                        tope.append(c);
                    }
                    else{
                        estado = 0;
                        i--;
                        agregarToken(tope.toString(), TipoToken.LETRA);
                    }*/
                break;

                case 28:
                    if( c == '='){
                        estado = 27;
                        tope.append(c);
                }
                    else{
                        estado = 0;
                        i--;
                        agregarToken(tope.toString(), TipoToken.CAD);
                }
                break;

                default:
                break;
            }
        }

        tokens.add(new Token(TipoToken.EOF, "", null, linea));
        return tokens;
    }

    private boolean transicion(char c, String r){
        return Pattern.compile(r).matcher(String.valueOf(c)).matches();
    }

    private void agregarToken(String tok){
        tokens.add(new Token(signos.get(tok), tok, null, num));
        tope.delete(0, tope.length());
    }

    private void agregarToken(String tok, TipoToken tt){
        tokens.add(new Token(tt, tok, null, num));
        tope.delete(0, tope.length());
    }


}

