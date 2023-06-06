import java.util.*

class Parser(private val tokens: List<Token>) {

    // Símbolos terminales
    private val id = Token(TokenType.IDENTIFIER)
    private val select = Token(TokenType.SELECT, "select")
    private val from = Token(TokenType.FROM, "from")
    private val distinct = Token(TokenType.DISTINCT, "distinct")
    private val comma = Token(TokenType.COMMA, ",")
    private val dot = Token(TokenType.DOT, ".")
    private val asterisk = Token(TokenType.ASTERISK, "*")
    private val eof = Token(TokenType.EOF)

    // Simbolos no terminales
    private val Q = NonTerminalSymbol.Q
    private val D = NonTerminalSymbol.D
    private val P = NonTerminalSymbol.P
    private val A = NonTerminalSymbol.A
    private val A1 = NonTerminalSymbol.A1
    private val A2 = NonTerminalSymbol.A2
    private val A3 = NonTerminalSymbol.A3
    private val T = NonTerminalSymbol.T
    private val T1 = NonTerminalSymbol.T1
    private val T2 = NonTerminalSymbol.T2
    private val T3 = NonTerminalSymbol.T3

    // Tipo de acciones
    private val shift = ActionType.SHIFT
    private val reduce = ActionType.REDUCE
    private val accept = ActionType.ACCEPT


    fun parse() {
        var i = 0
        var current = tokens[i]
        stack.push(0)

        while (i < tokens.size) {
            val state = stack.peek()
            val action = actionTable[state]?.entries?.find { (entry) ->
                entry == current
            }?.value

            // action.first puede ser shift, reduce o accept como se muetra en la sentencia when
            when (action?.first) {
                shift -> {
                    // action second indica hacia donde desplazar o sobre qué producción de la gramatica
                    // hay que reducir.
                    stack.push(action.second)
                    current = tokens[++i]
                }

                reduce -> {
                    var numberOfProductions = grammar[action.second]?.firstNotNullOf { it.value }?.size as Int

                    while (numberOfProductions > 0) {
                        stack.pop()
                        numberOfProductions--
                    }

                    stack.push(gotoTable[stack.peek()]?.get(grammar[action.second]?.keys?.first()))
                }

                accept -> {
                    println("Consulta válida")
                    break
                }

                else -> {
                    error(current.position, "Consulta no válida")
                    break
                }
            }
        }
    }
}