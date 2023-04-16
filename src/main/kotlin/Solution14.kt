/**
 * create by yangliu on 2023/4/16
 * package name :
 */
class Solution14 : Solution() {
    override fun solve() {
        println(longestCommonPrefix(arrayOf("flower","flow","flight")))
        println(longestCommonPrefix(arrayOf("dog","racecar","car")))
    }

    private fun longestCommonPrefix(strs: Array<String>): String {
        assert(strs.isNotEmpty())
        if (strs.size == 1) return strs[0]
        var minLength = Int.MAX_VALUE
        for (s in strs) minLength = minLength.coerceAtMost(s.length)
        if (minLength == 0) return ""
        var end = 0
        outer@ for (i in 0 until minLength) {
            val firstStr = strs[0]
            var index = 1
            while (index < strs.size) {
                if (firstStr[i] != strs[index][i]) {
                    // 第i个位置处的字符已经不完全一样了
                    break@outer
                }
                index++
            }
            end = i + 1
        }
        return strs[0].substring(0, end)
    }

    override fun link(): String {
        return "https://leetcode.com/problems/longest-common-prefix/"
    }

    override fun title(): String {
        return "Longest Common Prefix"
    }

    override fun description(): String {
        return "求字符串数组的最长公共前缀"
    }

    override fun thinking(): String {
        return """
            * 最短的字符串是可能存在的最大公共前缀
        """.trimMargin()
    }
}