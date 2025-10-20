import io.kotest.assertions.withClue
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

@Suppress("unused")
class WordleTest : StringSpec({
    "isValid should return true only for 5-letter alphabetic words" {
        withClue("Valid 5-letter word") {
            isValid("apple") shouldBe true
        }
        withClue("Too short") {
            isValid("app") shouldBe false
        }
        withClue("Contains digits") {
            isValid("a1ple") shouldBe false
        }
    }

    "evaluateGuess should correctly mark letters (0=absent,1=wrong position,2=correct)" {
        val result1 = evaluateGuess("apple", "apply")
        result1 shouldBe listOf(2, 2, 2, 2, 0)

        val result2 = evaluateGuess("crate", "trace")
        result2 shouldBe listOf(1, 2, 2, 1, 2)

        val result3 = evaluateGuess("words", "sword")
        result3 shouldBe listOf(1, 1, 1, 1, 1)
    }

    "pickRandomWord should remove the chosen word from list" {
        val words = mutableListOf("apple", "peach", "grape")
        val word = pickRandomWord(words)
        withClue("The chosen word must be from the list") {
            listOf("apple", "peach", "grape").contains(word) shouldBe true
        }
        withClue("The word must be removed from the list") {
            words.contains(word) shouldBe false
        }
    }

    "displayGuess should not throw any exceptions" {
        val guess = "apple"
        val matches = listOf(2, 1, 0, 1, 0)
        withClue("Display function should print safely") {
            displayGuess(guess, matches)
            true shouldBe true // dummy assertion to pass
        }
    }
})
