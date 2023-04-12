/**
 * create by yangliu on 2023/4/12
 * package name :
 */
class Solution3 : Solution() {
    override fun solve() {
        println(lengthOfLongestSubstring("abcabcbb"))
        println(lengthOfLongestSubstring("bbbbb"))
        println(lengthOfLongestSubstring("pwwkew"))
    }

    private fun lengthOfLongestSubstring(s: String): Int {
        val window = hashMapOf<Char, Int>()
        var left = 0
        var right = -1
        var max = 0
        while (left < s.length) {
            if (right + 1 < s.length && !window.containsKey(s[right + 1])) {
                // 窗口扩张
                right++
                window[s[right]] = right
            } else {
                // 窗口收缩
                if (right + 1 >= s.length) break
                val newLeft = window[s[right + 1]]!!
                for (i in left..newLeft) {
                    window.remove(s[i])
                }
                left = newLeft + 1
            }
            max = max.coerceAtLeast(right - left + 1)
        }
        return max
    }

    override fun link(): String {
        return "https://leetcode.com/problems/longest-substring-without-repeating-characters/"
    }

    override fun title(): String {
        return "Longest Substring Without Repeating Characters"
    }

    override fun description(): String {
        return """最长的没有重复字符的连续子串的长度
            注意：substring是连续的
        """.trimIndent()
    }

    override fun thinking(): String {
        return """
            滑动窗口解决
            时间复杂度O(n) 空间复杂度O(n)
        """.trimIndent()
    }
}