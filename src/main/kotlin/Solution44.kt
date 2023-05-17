/**
 * create by yangliu on 2023/5/17
 * package name :
 */
class Solution44 : Solution() {
    override fun solve() {
        println(isMatch("aa", "a"))
        println(isMatch("aa", "*"))
        println(isMatch("cb", "?a"))
        println(isMatch("aa", "aa*"))
    }

    private fun isMatch(s: String, p: String): Boolean {
        return isMatch(s, 0, p, 0)
    }


    private fun isMatch(
        s: String,
        sStart: Int,
        p: String,
        pStart: Int
    ): Boolean {
        if (sStart >= s.length && pStart >= p.length) return true
        if (sStart < s.length && pStart >= p.length) return false // 已经无法匹配了
        if (pStart < p.length && sStart >= s.length) {
            // 需要p剩下的部分全部是*
            for(i in pStart until p.length) {
                if (p[i] != '*') {
                    return false
                }
            }
            return true
        }
        val current = p[pStart]
        if (current == '?') {
            // 匹配?
            return isMatch(s, sStart + 1, p, pStart + 1)
        }
        if (current == '*') {
            // 如果跳过当前的*
            if (isMatch(s, sStart, p, pStart + 1)) return true
            // 如果不跳过当前的*
            for (j in sStart + 1 .. s.length) {
                if (isMatch(s, j, p, pStart + 1)) {
                    return true
                }
            }
            return false
        }
        // 对于非?和*
        return if (s[sStart] == current) {
             isMatch(s, sStart + 1, p, pStart + 1)
        } else {
            false
        }
    }


    override fun link(): String {
        return "https://leetcode.com/problems/wildcard-matching/"
    }

    override fun title(): String {
        return "Wildcard Matching"
    }

    override fun description(): String {
        return """通配符匹配
            ?匹配任意单个字符
            *匹配任意多个字符，包括空字符串
            要求完全匹配
        """.trimIndent()
    }

    override fun thinking(): String {
        return """
            先匹配模式的部分前缀，可能有多种匹配方式，每一种都要尝试，递归解决
        """.trimIndent()
    }
}