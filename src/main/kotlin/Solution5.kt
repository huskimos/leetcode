/**
 * create by yangliu on 2023/4/13
 * package name :
 */
class Solution5 : Solution() {
    override fun solve() {
        println(longestPalindrome("babad"))
        println(longestPalindrome("cbbd"))
    }

    private fun longestPalindrome(s: String): String {
        val dp = Array(s.length) { BooleanArray(s.length) { false } }
        var left = 0
        var right = 0
        var max = 0
        for (i in s.length - 1 downTo 0) {
            for (j in i until s.length) {
                dp[i][j] = when {
                    i == j -> true
                    i + 1 == j -> s[i] == s[j]
                    else -> s[i] == s[j] && dp[i + 1][j - 1]
                }
                if (dp[i][j] && max < j - i + 1) {
                    max = j - i + 1
                    left = i
                    right = j
                }
            }
        }
        return s.substring(left, right + 1)
    }

    override fun link(): String {
        return "https://leetcode.com/problems/longest-palindromic-substring/"
    }

    override fun title(): String {
        return "Longest Palindromic Substring"
    }

    override fun description(): String {
        return "最长回文子串"
    }

    override fun thinking(): String {
        return """
            * 暴力解法O(n ^ 3)
            * 动态规划 O(n ^ 2)
              * dp[i][j] 表示 [i, j]是否是回文串
              * dp[i][j] = if (i == j) true
                           else if (i + 1 == j) s[i] == s[j]
                           else dp[i + 1][j - 1] && s[i] == s[j]
        """.trimIndent()
    }
}