package org.Compiladores.Descendente

import java.util.Stack

class Parser(private val tokens: List<Token>) {

    private val select = Token(TokenType.SELECT, "select")
    private val from = Token(TokenType.FROM, "from")
    private val distinct = Token(TokenType.DISTINCT, "distinct")
    private val asterisk = Token(TokenType.ASTERISK, "*")
    private val comma = Token(TokenType.COMMA, ",")
    private val dot = Token(TokenType.DOT, ".")
    private val identifier = Token(TokenType.IDENTIFIER, "")
    private val eof = Token(TokenType.EOF, "")
    private val epsilon = Token(TokenType.EPSILON, "")

    private val parsingTable = mapOf(

    )

    private val stack = Stack<Any>()


    fun parse() {

    }

    private fun getProductions(topValueStack: Any, lookahead: Token)
            = parsingTable[topValueStack]?.entries?.find { (entry) -> lookahead == entry }?.value
}