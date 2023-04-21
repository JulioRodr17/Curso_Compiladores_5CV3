package org.Compiladores



import org.Compiladores.Token
import org.Compiladores.Scanner
import java.io.IOException
import java.nio.charset.Charset
import java.nio.file.Files
import java.nio.file.Paths
import java.io.InputStreamReader
import java.io.BufferedReader
import java.io.StringReader


var error: Boolean = false




@kotlin.jvm.Throws fun main(args: Array<String>) {

   // val args: String = readLine().toString()

    if(args.size > 1){
       println("Uso correcto: interprete [script]")

        // Convención defininida en el archivo "system.h" de UNIX
        System.exit(64)
    }
    else if(args.size == 1){
        println("Hola")
        ejecutarArchivo(args[0])
    }
    else{
        ejecutarPrompt()
    }




    

    //var tipo: Ttoken = Ttoken.EOF
    //var dattt = Token(tipo, "", {}, 0)
    //  println("$dattt")
}




fun ejecutarArchivo(path: String){
    IOException()
    val bytes: ByteArray = Files.readAllBytes(Paths.get(path))
    //  ejecutar(new String(bytes, Charset.defaultCharset()));
    ejecutar(String(bytes, Charset.defaultCharset()));

    // Se indica que existe un error
    if(error) System.exit(65);


}

fun ejecutar(source: String){
    var scanner = Scanner(source)
    val tokens: List<Token> = scanner.scanTokens()



    for(token: Token in tokens){
        println(token)
    }


}

fun ejecutarPrompt(){
    IOException()
    var input: InputStreamReader = InputStreamReader(System.`in`)
    var reader:BufferedReader = BufferedReader(input)
    val v: Boolean = true
    do{
        print("---> ")
        var linea: String = reader.readLine()
        if(linea == null){
            break // Ctrl + C para IntelliJ es Ctrl + D
        }
        ejecutar(linea)
        error = false

    }while(v == true)


}