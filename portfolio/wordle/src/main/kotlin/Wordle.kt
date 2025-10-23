fun isValid(word: String): Boolean = word.length == 5 && word.all { it.isLetter() }

fun readWordList(filename: String): MutableList<String> = java.io
    .File(filename)
    .readLines()
    .map { it.trim().uppercase() }
    .toMutableList()

fun pickRandomWord(words: MutableList<String>): String {
    val index = kotlin.random.Random.nextInt(words.size)
    return words.removeAt(index)
}

fun obtainGuess(attempt: Int): String {
    while (true) {
        print("Attempt $attempt: ")
        val guess = readlnOrNull()?.trim()?.uppercase() ?: ""
        if (isValid(guess)) return guess
        println("Invalid word. Please enter exactly 5 letters.")
    }
}

fun evaluateGuess(guess: String, target: String): List<Int> {
    val length = guess.length
    val result = MutableList(length) { 0 }
    for (i in 0 until length) {
        if (guess[i] == target[i]) {
            result[i] = 1
        }
    }
    return result
}

fun displayGuess(guess: String, matches: List<Int>) {
    val length = guess.length
    for (i in 0 until length) {
        if (matches[i] == 1) {
            print(guess[i].uppercase())
        } else {
            print("?")
        }
    }
    println()
}
