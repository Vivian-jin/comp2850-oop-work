// Task 5.1.1: anagram checking using a function
fun anagrams(first: String, second: String): Boolean {
    if (first.length != second.length) {
        return false
    }
    val firstChars = first.lowercase().toList().sorted()
    val secondChars = second.lowercase().toList().sorted()
    return firstChars == secondChars
}
fun main() {
    print("Please enter the first string: ")
    val str1=readln()
    print("Please enter the secomd strig: ")
    val str2=readln()
    if (anagrams(str1,str2)){
        print("$str1'and '$str2'is anagrams.")
    } else{
        print("'$str1' and '$str2' are not anagrams.")
    }
}
