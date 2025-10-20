// 判断单词是否有效（必须是 5 个字母）
fun isValid(word: String): Boolean = word.length == 5 && word.all { it.isLetter() }

// 从文件中读取单词列表
fun readWordList(filename: String): MutableList<String> = java.io
    .File(filename)
    .readLines()
    .map { it.trim().lowercase() }
    .toMutableList()

// 随机选择一个单词并从列表中移除
fun pickRandomWord(words: MutableList<String>): String {
    val index = kotlin.random.Random.nextInt(words.size)
    return words.removeAt(index)
}

// 获取用户输入并验证
fun obtainGuess(attempt: Int): String {
    while (true) {
        print("Attempt $attempt: ")
        val guess = readlnOrNull()?.trim()?.lowercase() ?: ""
        if (isValid(guess)) return guess
        println("❌ Invalid word. Please enter exactly 5 letters.")
    }
}

// 比较猜测与目标单词
// 0 = 不存在，1 = 存在但错位，2 = 完全正确
fun evaluateGuess(guess: String, target: String): List<Int> {
    val length = guess.length
    val result = MutableList(length) { 0 }
    val used = BooleanArray(length)

    // 先检查完全匹配
    for (i in 0 until length) {
        if (guess[i] == target[i]) {
            result[i] = 2
            used[i] = true
        }
    }

    // 再检查存在但错位
    for (i in 0 until length) {
        if (result[i] == 0) {
            for (j in 0 until length) {
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


// 显示结果，带颜色输出
fun displayGuess(guess: String, matches: List<Int>) {
    for (i in guess.indices) {
        when (matches[i]) {
            2 -> print("\u001B[32m${guess[i].uppercase()}\u001B[0m") // 绿色：完全正确
            1 -> print("\u001B[33m${guess[i].uppercase()}\u001B[0m") // 黄色：错位
            else -> print("\u001B[37m${guess[i].uppercase()}\u001B[0m") // 灰色：不存在
        }
    }
    println()
}
