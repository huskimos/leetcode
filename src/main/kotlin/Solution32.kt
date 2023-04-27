import java.util.*

/**
 * create by yangliu on 2023/4/27
 * package name :
 */
class Solution32 : Solution() {
    override fun solve() {
        println(longestValidParentheses("(()"))
        println(longestValidParentheses("()(()()"))
        println(longestValidParentheses(""))
    }

    private fun longestValidParentheses(s: String): Int {
        if (s.isEmpty()) return 0
        val stack = Stack<Int>()
        for ((i, c) in s.withIndex()) {
            if (stack.isEmpty()) {
                stack.push(i)
            } else if (c == ')' && s[stack.peek()] == '(') {
                stack.pop()
            } else {
                stack.push(i)
            }
        }
        if (stack.isEmpty()) return s.length
        var max = 0
        var end = s.length
        while (stack.isNotEmpty()) {
            val top = stack.pop()
            max = max.coerceAtLeast(end - top - 1)
            end = top
        }
        // 判断[0~end)之间是不是有效的括号
        if (end > 0) {
            max = max.coerceAtLeast(end)
        }
        return max
    }

    override fun link(): String {
        return "https://leetcode.com/problems/longest-valid-parentheses/"
    }

    override fun title(): String {
        return "Longest Valid Parentheses"
    }

    override fun description(): String {
        return "最长有效括号的长度"
    }

    override fun thinking(): String {
        return """
            括号匹配使用栈，但是栈中不是存'('和')'而是存他们的索引
            最后栈中剩下的索引即是不能匹配的括号，他们之间间隔的最大值就是最长的有效括号，
            注意要把0和s.length这两个端点考虑上
        """.trimIndent()
    }
}