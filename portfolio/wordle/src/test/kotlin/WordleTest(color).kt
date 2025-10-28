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
    "readWordList should correctly read and uppercase words" {
        val testFile = java.io.File("test_words.txt")
        testFile.writeText("apple\npeach\ngrape")
        val result = readWordList("test_words.txt")
        result shouldBe mutableListOf("APPLE", "PEACH", "GRAPE")
        testFile.delete()
    }

    "evaluateGuess should correctly mark letters (0=not match, 1=different position, 2=correct)" {
        val result1 = evaluateGuess("apple", "apply")
        result1 shouldBe listOf(2, 2, 2, 2, 0)
        val result2 = evaluateGuess("creat", "train")
        result2 shouldBe listOf(0, 2, 0, 1, 1)
        val result3 = evaluateGuess("words", "sword")
        result3 shouldBe listOf(1, 1, 1, 1, 1)
        val result4 = evaluateGuess("basic", "prove")
        result4 shouldBe listOf(0, 0, 0, 0, 0)
        val result5 = evaluateGuess("ready", "ready")
        result5 shouldBe listOf(2, 2, 2, 2, 2)
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
})
