fun main() {
    val words = readWordList("data/words.txt")
    val target = pickRandomWord(words)

    println("Welcome to Wordle !")
    println("You have 6 attempts to guess the 5-letter word.\n")

    for (attempt in 1..6) {
        val guess = obtainGuess(attempt)
        val result = evaluateGuess(guess, target)
        displayGuess(guess, result)

        if (result.all { it == 1 }) {
            println("Congratulations! You guessed the word '$target' in $attempt attempts!")
            return
        }
    }

    println("💀 Sorry! You've used all attempts. The correct word was '$target'.")
}
