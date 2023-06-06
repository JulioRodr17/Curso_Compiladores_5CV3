import java.util.*

class Parser(private val tokens: List<Token>) {




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