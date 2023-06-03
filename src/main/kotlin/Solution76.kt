/**
 * create by yangliu on 2023/6/3
 * package name :
 */
class Solution76 : Solution() {
    override fun solve() {
        println(minWindow("ADOBECODEBANC", "ABC"))
    }

    private fun minWindow(s: String, t: String): String {
        val pattern = hashMapOf<Char, Int>()
        for (c in t) {
            pattern[c] = pattern.getOrDefault(c, 0) + 1
        }
        var left = 0
        var right = -1
        val window = hashMapOf<Char, Int>()
        var minWindowSize = Int.MAX_VALUE
        var minWindowLeft = 0
        var minWindowRight = -1
        var lastMatch = false
        while (left < s.length) {
            if (right + 1 < s.length && !lastMatch) {
                right++
                window[s[right]] = window.getOrDefault(s[right], 0) + 1
            } else if (lastMatch) {
                // 尝试收缩，寻找最优解
                window[s[left]]?.let { window[s[left]] = it - 1 }
                if (window[s[left]] == 0) {
                    window.remove(s[left])
                }
                left++
            } else {
                // 窗口已经不能再扩张，且不能匹配
                break
            }
            lastMatch = match(window, pattern)
            if (lastMatch) {
                // 窗口移动之后再次检查
                if (minWindowSize > right - left + 1) {
                    minWindowSize = right - left + 1
                    minWindowLeft = left
                    minWindowRight = right
                }
            }
        }
        return s.substring(minWindowLeft, minWindowRight + 1)
    }

    private fun match(window: Map<Char, Int>, pattern: Map<Char, Int>): Boolean {
        for ((c, f) in pattern) {
            val wc = window[c]
            if (wc == null || wc < f) {
                return false
            }
        }
        return true
    }

    override fun link(): String {
        return "https://leetcode.com/problems/minimum-window-substring/"
    }

    override fun title(): String {
        return "Minimum Window Substring"
    }

    override fun description(): String {
        return "最小窗口子串"
    }

    override fun thinking(): String {
        return "滑动窗口"
    }
}