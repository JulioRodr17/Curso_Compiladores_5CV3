package org.Compiladores.Java;

public class Token {

    final TipoToken tipo;
    final String lexema;
    final Object literal;
    final int linea;

    public Token(TipoToken tipo, String lexema, Object literal, int linea) {
        this.tipo = tipo;
        this.lexema = lexema;
        this.literal = literal;
        this.linea = linea;
    }

    public Token(TipoToken tipo, String lexema) {
        this.tipo = tipo;
        this.lexema = lexema;
        this.literal = null;
        this.linea = 0;
    }

    public int tenerLinea(){
        return this.linea;
    }

    @Override
    public boolean equals(Object o){
        if(!(o instanceof Token)){
            return false;
        }
        return this.tipo == ((Token) o).tipo;
    }

    @Override
    public String toString(){
        return tipo + " " + lexema + " " + literal;
    }
}
