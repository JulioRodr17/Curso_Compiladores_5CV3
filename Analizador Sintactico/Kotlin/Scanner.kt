class Scanner(private val source: String) {

    private val tokens: MutableList<Token> = ArrayList()
    private val keywords: MutableMap<String, TokenType> = HashMap()

    init {
        keywords["select"]   = TokenType.SELECT
        keywords["from"]     = TokenType.FROM
        keywords["distinct"] = TokenType.DISTINCT
    }

}