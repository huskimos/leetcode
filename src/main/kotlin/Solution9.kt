/**
 * create by yangliu on 2023/4/14
 * package name :
 */
class Solution9 : Solution() {
    override fun solve() {
        println(isPalindrome(121))
        println(isPalindrome(123))
        println(isPalindrome(1221))
    }

    private fun isPalindrome(x: Int): Boolean {
        val str = x.toString()
        for (i in 0 until str.length / 2) {
            if (str[i] != str[str.length - 1 -i]) {
                return false
            }
        }
        return true
    }

    override fun link(): String {
        return "https://leetcode.com/problems/palindrome-number/"
    }

    override fun title(): String {
        return "Palindrome Number"
    }

    override fun description(): String {
        return "判断回文数"
    }

    override fun thinking(): String {
        return ""
    }
}