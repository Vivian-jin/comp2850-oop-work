const val MAX_ATTEMPTS = 6

fun main() {
    val words = readWordList("data/words.txt")
    val target = pickRandomWord(words)

    println("Welcome to Wordle!")
    println("You have $MAX_ATTEMPTS attempts to guess the 5-letter word.\n")

    for (attempt in 1..MAX_ATTEMPTS) {
        val guess = obtainGuess(attempt)
        val result = evaluateGuess(guess, target)
        displayGuess(guess, result)

        if (result.all { it == 2 }) {
            println("Congratulations! You guessed the word '$target' in $attempt attempts!")
            return
        }
    }

    println("Sorry! You've used all attempts. The correct word was '$target'.")
}
