/**
 * create by yangliu on 2023/4/23
 * package name :
 */
class Solution28 : Solution() {
    override fun solve() {
        println(strStr("sadbutsad", "but"))
    }

    private fun strStr(haystack: String, needle: String): Int {
        outer@ for (i in haystack.indices) {
            // 长度不够了
            if (haystack.length - i < needle.length) break
            for (j in needle.indices) {
                if (haystack[i + j] != needle[j]) {
                    // 不匹配
                    continue@outer
                }
            }
            return i
        }
        return -1
    }

    override fun link(): String {
        return "https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/"
    }

    override fun title(): String {
        return "Find the Index of the First Occurrence in a String"
    }

    override fun description(): String {
        return "找出一个字符串在另一个字符串中第一次出现的位置"
    }

    override fun thinking(): String {
        return "字符串匹配，KMP之类的？"
    }
}