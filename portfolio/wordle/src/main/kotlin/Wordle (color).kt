const val WORD_LENGTH = 5
fun isValid(word: String): Boolean {
    return word.length == WORD_LENGTH && word.all { it.isLetter() }
}

fun readWordList(filename: String): MutableList<String> {
    return java.io.File(filename).readLines().map { it.trim().uppercase() }.toMutableList()
}


fun pickRandomWord(words: MutableList<String>): String {
    val index = kotlin.random.Random.nextInt(words.size)
    return words.removeAt(index)
}

fun obtainGuess(attempt: Int): String {
    while (true) {
        print("Attempt $attempt: ")
        val guess = readlnOrNull()?.trim()?.lowercase() ?: ""
        if (isValid(guess)) return guess
        println("Invalid word. Please enter exactly 5 letters.")
    }
}

fun evaluateGuess(guess: String, target: String): List<Int> {
    val result = MutableList(5) { 0 }
    val used = BooleanArray(5)

    for (i in 0 until WORD_LENGTH) {
        if (guess[i] == target[i]) {
            result[i] = 2
            used[i] = true
        }
    }
    for (i in 0 until WORD_LENGTH) {
        if (result[i] == 0) {
            for (j in 0 until WORD_LENGTH) {
                if (!used[j] && guess[i] == target[j]) {
                    result[i] = 1
                    used[j] = true
                    break
                }
            }
        }
    }
    return result
}


fun displayGuess(guess: String, matches: List<Int>) {
    for (i in guess.indices) {
        when (matches[i]) {
            2 -> print("\u001B[32m${guess[i].uppercase()}\u001B[0m") 
            1 -> print("\u001B[31m${guess[i].uppercase()}\u001B[0m")
            else -> print("\u001B[37m${guess[i].uppercase()}\u001B[0m")
        }
    }
    println()
}

