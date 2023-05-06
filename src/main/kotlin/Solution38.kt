import java.lang.StringBuilder

/**
 * create by yangliu on 2023/5/5
 * package name :
 */
class Solution38 : Solution() {
    override fun solve() {
        println(countAndSay(1))
        println(countAndSay(2))
        println(countAndSay(3))
        println(countAndSay(4))
        println(countAndSay(5))
    }

    private fun countAndSay(n: Int): String {
        if (n == 1) return "1"
        val prev = countAndSay(n - 1)
        var count = 1
        var current = prev[0]
        val result = StringBuilder()
        for (i in 1 until prev.length) {
            if (prev[i] == prev[i - 1]) {
                count++
            } else {
                result.append("$count$current")
                current = prev[i]
                count = 1
            }
        }
        result.append("$count$current")
        return result.toString()
    }

    override fun link(): String {
        return "https://leetcode.com/problems/count-and-say/"
    }

    override fun title(): String {
        return "Count and Say"
    }

    override fun description(): String {
        return "Count and Say"
    }

    override fun thinking(): String {
        return "递归"
    }
}