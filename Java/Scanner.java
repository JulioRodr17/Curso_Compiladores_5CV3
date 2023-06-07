package org.Compiladores.Java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Scanner {

    private final String source;
    private final List<Token> tokens;

    private static final Map<String, TipoToken> palabrasReservadas;

    private int linea; //numberline

    public StringBuilder tope;


    static {
        palabrasReservadas = new HashMap<>();


        //palabras reservadas que ayudan a la lectura
        palabrasReservadas.put("false", TipoToken.FALSE);
        palabrasReservadas.put("for", TipoToken.FOR);
        palabrasReservadas.put("fun", TipoToken.FUN); //definir funciones
        palabrasReservadas.put("if", TipoToken.IF);
        palabrasReservadas.put("null", TipoToken.NULL);
        palabrasReservadas.put("else", TipoToken.ELSE);
        palabrasReservadas.put("print", TipoToken.PRINT);
        palabrasReservadas.put("return", TipoToken.RETURN);
        palabrasReservadas.put("super", TipoToken.SUPER);
        palabrasReservadas.put("this", TipoToken.THIS);
        palabrasReservadas.put("true", TipoToken.TRUE);
        palabrasReservadas.put("while", TipoToken.WHILE);
        palabrasReservadas.put("class", TipoToken.CLASE);
        palabrasReservadas.put("id", TipoToken.ID);
    }

    Scanner(String source) {
        this.source = source;
        this.tope = new StringBuilder();
        this.tokens = new ArrayList<>();
        linea = 1;
    }

    List<Token> scanTokens() {

        int estado = 0;

        for(int i = 0; i <= source.length(); i++) {

            char c = caracterActual(i, source.length());
            linea = incrementarLinea(c);

            switch (estado) {
                case 0:
                    if(c != '\0'){
                        if(c == '<'){
                            estado = 1;
                            tope.append(c);
                        }
                        else if(c == '='){
                            estado = 2;
                            tope.append(c);
                        }
                        else if(c == '>'){
                            estado = 3;
                            tope.append(c);
                        }
                        else if(c == '!'){
                            estado = 4;
                            tope.append(c);
                        }
                        else if(c == '('){
                            estado = 5;
                            tope.append(c);
                        }
                        else if(c == ')'){
                            estado = 6;
                            tope.append(c);
                        }
                        else if(c == '['){
                            estado = 7;
                            tope.append(c);
                        }
                        else if(c == ']'){
                            estado = 8;
                            tope.append(c);
                        }
                        else if(c == '{'){
                            estado = 9;
                            tope.append(c);
                        }
                        else if(c == '}'){
                            estado = 10;
                            tope.append(c);
                        }
                        else if(c == '"'){
                            estado = 11;
                            tope.append(c);
                        }
                        else if(Character.isDigit(c)){
                            estado = 12;
                            tope.append(c);
                        }
                        else if(c == '+'){
                            estado = 18;
                            tope.append(c);
                        }
                        else if(c == '-'){
                            estado = 19;
                            tope.append(c);
                        }
                        else if(c == '*'){
                            estado = 20;
                            tope.append(c);
                        }
                        else if(c == '/'){
                            estado = 21;
                            tope.append(c);
                        }
                        else if(c == '%'){
                            estado = 22;
                            tope.append(c);
                        }
                        else if(c == '&'){
                            estado = 23;
                            tope.append(c);
                        }
                        else if(c == '|'){
                            estado = 24;
                            tope.append(c);
                        }
                        else if(Character.isLetter(c)){
                            estado = 25;
                            tope.append(c);
                        }
                        else if(c == '_'){
                            estado = 26;
                            tope.append(c);
                        }
                        else if(Character.isSpaceChar(c) || Character.isISOControl(c)){
                            estado = 27;
                            tope.append(c);
                        }
                        else if(c == ';'){
                            tope.append(c);
                            agregarToken(TipoToken.COMA, tope.toString());
                        }
                        else if(c == '.'){
                            tope.append(c);
                            agregarToken(TipoToken.PUNTO, tope.toString());
                        }
                        else{
                            throw new RuntimeException("Incapaz de Analizar" + c);
                        }
                    }
                break;


                case 1:
                    estado = 0;
                    if (c == '=') {
                        tope.append(c);
                        agregarToken(TipoToken.MENOR_IGUAL, tope.toString());
                    }
                    else{
                        i--;
                        agregarToken(TipoToken.MENOR, tope.toString());
                    }
                break;
                case 2:
                    estado = 0;
                    if (c == '=') {
                        tope.append(c);
                        agregarToken(TipoToken.IGUAL, tope.toString());
                    }
                    else{
                        i--;
                        agregarToken(TipoToken.ASIGNAR, tope.toString());
                    }
                break;
                case 3:
                    estado = 0;
                    if (c == '=') {
                        tope.append(c);
                        agregarToken(TipoToken.MAYOR_IGUAL, tope.toString());
                    }
                    else{
                        i--;
                        agregarToken(TipoToken.MAYOR, tope.toString());
                    }
                break;
                case 4:
                    estado = 0;
                    if (c == '=') {
                        tope.append(c);
                        agregarToken(TipoToken.NO_IGUAL, tope.toString());
                    }
                    else{
                        i--;
                        agregarToken(TipoToken.NOT, tope.toString());
                    }
                break;
                case 5:
                    estado = 0;
                    i--;
                    agregarToken(TipoToken.IZ_PAR, tope.toString());
                break;
                case 6:
                    estado = 0;
                    i--;
                    agregarToken(TipoToken.DER_PAR, tope.toString());
                break;
                case 7:
                    estado = 0;
                    i--;
                    agregarToken(TipoToken.IZ_CORCH, tope.toString());
                break;
                case 8:
                    estado = 0;
                    i--;
                    agregarToken(TipoToken.DER_CORCH, tope.toString());
                break;
                case 9:
                    estado = 0;
                    i--;
                    agregarToken(TipoToken.IZ_LLAVE, tope.toString());
                break;
                case 10:
                    estado = 0;
                    i--;
                    agregarToken(TipoToken.DER_LLAVE, tope.toString());
                break;
                case 11:
                    if(c != '"' && c != '\0'){
                        tope.append(c);
                    }
                break;
                case 12:
                    if(c >= '0' && c <= '9'){
                        tope.append(c);
                    }
                    else if(c == '.'){
                        estado = 13;
                        tope.append(c);
                    }
                    else if (c == 'e'|| c == 'E') {
                        estado = 15;
                        tope.append(c);
                    }
                    else{
                        i--;
                        estado = 0;
                        agregarToken(TipoToken.NUM, tope.toString(), Integer.parseInt(tope.toString()));
                    }
                break;
                case 13:
                    if(c >= '0' && c <= '9'){
                        estado = 14;
                        tope.append(c);
                    }
                    else{
                        throw new RuntimeException("Incapaz de Analizar" + c);
                    }
                break;
                case 14:
                   if(c >= '0' && c <= '9'){
                       tope.append(c);
                   }
                   else if(c == 'e' || c == 'E'){
                        estado = 15;
                        tope.append(c);
                   }
                   else{
                       i--;
                       estado = 0;
                       agregarToken(TipoToken.NUM, tope.toString(), Float.parseFloat(tope.toString()));
                   }
                break;
                case 15:
                    if(c >= '0' && c <= '9'){
                        estado = 17;
                        tope.append(c);
                    }
                    else if(c == '+' || c == '-'){
                        estado = 16;
                        tope.append(c);
                    }
                    else{
                        throw new RuntimeException("Incapaz de Analizar" + c);
                    }
                break;
                case 16:
                    if(c >= '0' && c <= '9'){
                        estado = 17;
                        tope.append(c);
                    }
                    else{
                        throw new RuntimeException("Incapaz de Analizar" + c);
                    }
                break;
                case 17:
                    if(c >= '0' && c <= '9'){
                        tope.append(c);
                    }
                    else{
                        i--;
                        estado = 0;
                        agregarToken(TipoToken.NUM, tope.toString(), Double.parseDouble(tope.toString()));
                    }
                break;
                case 18:
                    estado =  0;
                    if(c == '='){
                        tope.append(c);
                        agregarToken(TipoToken.MAS_IGUAL, tope.toString());
                    }
                    else{
                        i--;
                        agregarToken(TipoToken.MAS, tope.toString());
                    }
                break;
                case 19:
                  estado = 0;
                  if(c == '='){
                      tope.append(c);
                      agregarToken(TipoToken.MENOS_IGUAL, tope.toString());
                  }
                  else{
                      i--;
                      agregarToken(TipoToken.MENOS, tope.toString());
                  }
                break;
                case 20:
                  estado = 0;
                    if(c == '='){
                        tope.append(c);
                        agregarToken(TipoToken.POR_IGUAL, tope.toString());
                    }
                    else{
                        i--;
                        agregarToken(TipoToken.MULTIPLICA, tope.toString());
                    }
                break;
                case 21:
                  estado = 0;
                    if(c == '='){
                        tope.append(c);
                        agregarToken(TipoToken.ENTRE_IGUAL, tope.toString());
                    }
                    else if( c == '/'){
                        estado = 28;
                        tope.append(c);
                    }
                    else if(c == '*'){
                        estado = 29;
                        tope.append(c);
                    }
                    else {
                        i--;
                        agregarToken(TipoToken.DIVIDE, tope.toString());
                    }
                break;
                case 22:
                    estado = 0;
                    if(c == '='){
                        tope.append(c);
                        agregarToken(TipoToken.MOD_IGUAL, tope.toString());
                    }
                    else{
                        i--;
                        agregarToken(TipoToken.MODULO, tope.toString());
                    }
                break;
                case 23:

                   if(c == '&'){
                       estado = 0;
                        tope.append(c);
                        agregarToken(TipoToken.AND, tope.toString());
                    }
                    else{
                       throw new RuntimeException("Incapaz de Analizar" + tope);
                    }
                break;
                case 24:
                    if(c == '|'){
                        estado = 0;
                        tope.append(c);
                        agregarToken(TipoToken.OR, tope.toString());
                    }
                    else{
                        throw new RuntimeException("Incapaz de Analizar" + tope);
                    }
                break;
                case 25:
                    if(Character.isLetterOrDigit(c) || c == '_'){
                        tope.append(c);
                    }
                    else{
                        i--;
                        estado = 0;
                        agregarToken(TipoToken.ID, tope.toString());
                    }
                break;
                case 26:
                    if(Character.isLetterOrDigit(c)){
                        estado = 25;
                        tope.append(c);
                    }
                    else if(c == '_'){
                        tope.append(c);
                    }
                    else{
                        throw new RuntimeException("Incapaz de Analizar" + tope);
                    }
                break;
                case 27:
                    if(c == ' ' || c == '\t' || c == '\n' || c == '\r'){
                        tope.append(c);
                    }
                    else{
                        i--;
                        estado = 0;
                        tope.delete(0, tope.length());
                    }
                break;
                case 28:
                    if(c != '\n'){
                        tope.append(c);
                    }
                    else{
                        i--;
                        estado = 0;
                        tope.delete(0, tope.length());
                    }
                break;
                case 29:
                    if (c == '*') {
                        estado = 30;
                    } else {
                        tope.append(c);
                    }
                break;
                case 30:
                  if(c == '/'){
                      estado = 31;
                  }
                  tope.append(c);
                break;
                case 31:
                  i--;
                  estado = 0;
                  tope.delete(0, tope.length());
                break;


            }

            tokens.add(new Token(TipoToken.EOF, "", null, linea));
            return tokens;

        }

        tokens.add(new Token(TipoToken.EOF, "", null, linea));
        return tokens;
    }


    private void agregarToken(TipoToken tipo, String tope){
        if(tipo == TipoToken.IDENTIFICADOR){
            tipo = palabrasReservadas.getOrDefault(tope, TipoToken.IDENTIFICADOR);
        }
        tokens.add(new Token(tipo, tope, null, linea));
        this.tope.delete(0, this.tope.length());
    }

    private void agregarToken(TipoToken tipo, String tope, Object literal){
        if(tipo == TipoToken.IDENTIFICADOR){
            tipo = palabrasReservadas.getOrDefault(tope, TipoToken.IDENTIFICADOR);
        }
        tokens.add(new Token(tipo, tope, literal, linea));
        this.tope.delete(0, this.tope.length());
    }

    private int incrementarLinea(char c){
        if(c == '\n') linea++;
        return linea;
    }

    private char caracterActual(int i, int longSource){
        if( i >= longSource){
            return '\0';
        }
        return source.charAt(i);
    }

}