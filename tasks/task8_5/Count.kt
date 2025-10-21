fun String.howMany(include: (Char) -> Boolean): Int {
    var count = 0
    for (character in this) {
        if (include(character)) {
            count += 1
        }
    }
    return count
}
fun main(){
    val text = "Hello Vivian 12345!"
    val letters=text.howMany{it.isLetter()}
    println("Number of letters:$letters")
    val digits=text.howMany{it.isDigit()}
    println("Number of digits:$digits")
    val spaces=text.howMany{it.isWhitespace()}
    println("Number of spaces:$spaces")
    val uppercases=text.howMany{it.isUpperCase()}
    println("Number of uppercases:$uppercases")
}