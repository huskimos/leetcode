/**
 * create by yangliu on 2023/5/25
 * package name :
 */
class Solution58 : Solution() {
    override fun solve() {
        println(lengthOfLastWord("Hello World"))
    }

    private fun lengthOfLastWord(s: String): Int {
        return s.split(" ").last { it.isNotEmpty() }.length
    }

    override fun link(): String {
        return "https://leetcode.com/problems/length-of-last-word/"
    }

    override fun title(): String {
        return "Length of Last Word"
    }

    override fun description(): String {
        return "最后一个单词的长度"
    }

    override fun thinking(): String {
        return ""
    }
}