import java.util.*

/**
 * create by yangliu on 2023/4/22
 * package name :
 */
class Solution22 : Solution() {
    override fun solve() {
        println(generateParenthesis(3))
    }

    private fun generateParenthesis(n: Int): List<String> {
        val result = arrayListOf<String>()
        generateParenthesis(n, n, n, arrayListOf(), result)
        return result.filter { isValid(it) }
    }

    /**
     * @param left 还剩几个左括号
     * @param right 还剩几个右括号
     */
    private fun generateParenthesis(
        n: Int,
        left: Int,
        right: Int,
        current: MutableList<Char>,
        result: MutableList<String>) {
        if (left == 0 && right == 0) {
            result.add(String(current.toCharArray()))
            return
        }
        if (left > 0) {
            // 先试一下左括号
            current.add('(')
            generateParenthesis(n, left - 1, right, current, result)
            current.removeAt(current.lastIndex)
        }
        if (right > 0) {
            current.add(')')
            generateParenthesis(n, left, right - 1, current, result)
            current.removeAt(current.lastIndex)
        }
    }

    private fun isValid(parenthesis: String): Boolean {
        if (parenthesis.isNullOrBlank()) return false
        val stack = Stack<Char>()
        for (c in parenthesis) {
            if (stack.isEmpty() || c == '(') {
                stack.push(c)
            } else {
                stack.pop()
            }
        }
        return stack.isEmpty()
    }

    override fun link(): String {
        return "https://leetcode.com/problems/generate-parentheses/"
    }

    override fun title(): String {
        return "Generate Parentheses"
    }

    override fun description(): String {
        return "生成有效的括号"
    }

    override fun thinking(): String {
        return """
            先回溯生成所有括号的组合然后判断是否有效
            优化思路：提前剪枝
        """.trimIndent()
    }
}