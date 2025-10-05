import kotlin.math.roundToInt

fun main(args: Array<String>) {
    // Step 1: Check number of command line arguments
    if (args.size != 3) {
        println("Error: Please provide exactly three marks (0–100).")
        return
    }

    // Step 2: Convert input to integers
    val marks = try {
        args.map { it.toInt() }
    } catch (e: NumberFormatException) {
        println("Error: All inputs must be integers.")
        return
    }

    // Step 3: Check that all marks are within 0–100
    if (marks.any { it < 0 || it > 100 }) {
        println("Error: Marks must be between 0 and 100.")
        return
    }

    // Step 4: Calculate average and round it
    val average = marks.average().roundToInt()

    // Step 5: Determine grade using when expression
    val grade = when (average) {
        in 70..100 -> "Distinction"
        in 40..69  -> "Pass"
        in 0..39   -> "Fail"
        else       -> "?"
    }

    // Step 6: Output the result
    println("Average mark: $average")
    println("Grade: $grade")
}
