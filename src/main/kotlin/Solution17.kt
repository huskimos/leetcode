import java.lang.StringBuilder

/**
 * create by yangliu on 2023/4/18
 * package name :
 */
class Solution17 : Solution() {
    override fun solve() {
        println(letterCombinations("23"))
        println(letterCombinations("2"))
        println(letterCombinations(""))
    }

    private val board = hashMapOf<Int, List<Char>>().apply {
        put(2, listOf('a', 'b', 'c'))
        put(3, listOf('d', 'e', 'f'))
        put(4, listOf('g', 'h', 'i'))
        put(5, listOf('j', 'k', 'l'))
        put(6, listOf('m', 'n', 'o'))
        put(7, listOf('p', 'q', 'r', 's'))
        put(8, listOf('t', 'u', 'v'))
        put(9, listOf('w', 'x', 'y', 'z'))
    }

    private fun letterCombinations(digits: String): List<String> {
        if (digits.isEmpty()) return emptyList()
        if (digits.length == 1) {
            return board[digits[0] - '0']?.map { String(charArrayOf(it)) } ?: emptyList()
        }
        val result = arrayListOf<String>()
        letterCombinations(digits, 0, arrayListOf(), result)
        return result
    }

    private fun letterCombinations(digits: String, index: Int, current: MutableList<Char>, result: MutableList<String>) {
        if (index >= digits.length) {
            result.add(String(current.toCharArray()))
            return
        }
        for (c in board[digits[index] - '0']!!) {
            current.add(c)
            letterCombinations(digits, index + 1, current, result)
            current.removeAt(current.lastIndex)
        }
    }

    override fun link(): String {
        return "https://leetcode.com/problems/letter-combinations-of-a-phone-number/"
    }

    override fun title(): String {
        return "Letter Combinations of a Phone Number"
    }

    override fun description(): String {
        return """电话号码对应九宫格按键上的字母组合
            |注意：电话号码只有2-9
        """.trimMargin()
    }

    override fun thinking(): String {
        return "回溯"
    }
}