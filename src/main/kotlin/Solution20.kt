import java.util.*

/**
 * create by yangliu on 2023/4/21
 * package name :
 */
class Solution20 : Solution() {
    override fun solve() {
        println(isValid("[()]{}"))
        println(isValid("()[(]{}"))
        println(isValid("(])"))
    }

    private fun isValid(s: String): Boolean {
        val stack = Stack<Char>()
        val leftParentheses = listOf('(', '[', '{')
        for (c in s) {
            if (stack.isEmpty() || c in leftParentheses) {
                stack.push(c)
            } else {
                val top = stack.peek()
                if ((c == ')' && top == '(')
                    || (c == ']' && top == '[')
                    || (c == '}' && top == '{')) {
                    stack.pop()
                } else {
                    stack.push(c)
                }
            }
        }
        return stack.isEmpty()
    }

    override fun link(): String {
        return "https://leetcode.com/problems/valid-parentheses/"
    }

    override fun title(): String {
        return "Valid Parentheses"
    }

    override fun description(): String {
        return "验证括号"
    }

    override fun thinking(): String {
        return "使用栈"
    }
}