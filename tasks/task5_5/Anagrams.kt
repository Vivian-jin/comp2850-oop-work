// Task 5.1.1: anagram checking using a function
infix fun String.anagramOf(other: String): Boolean {
    if (this.length != other.length) {
        return false
    }
    val firstChars = this.lowercase().toList().sorted()
    val secondChars = other.lowercase().toList().sorted()
    return firstChars == secondChars
}

fun main() {
    print("Please enter the first string: ")
    val str1 = readln()
    print("Please enter the second string: ")
    val str2 = readln()


    if (str2 anagramOf str1) {
        println("'$str1' and '$str2' are anagrams!")
    } else {
        println("'$str1' and '$str2' are not anagrams.")
    }
}
