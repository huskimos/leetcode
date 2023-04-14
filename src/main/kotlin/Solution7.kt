/**
 * create by yangliu on 2023/4/14
 * package name :
 */
class Solution7 : Solution() {
    override fun solve() {
        println(reverse(123))
        println(reverse(-123))
        println(reverse(120))
        println(reverse(1222299999))
    }

    private fun reverse(x: Int): Int {
        var str = x.toString()
        val negative = str[0] == '-'
        if (negative) str = str.substring(1)
        var value = 0L
        for (i in str.length - 1 downTo 0) {
            value = (value * 10) + (str[i] - '0')
            // 检查是否溢出
            if (negative) {
                if (-value < Int.MIN_VALUE) {
                    return 0
                }
            } else {
                if (value > Int.MAX_VALUE) {
                    return 0
                }
            }
        }
        return if (negative) -value.toInt() else value.toInt()
    }

    override fun link(): String {
        return "https://leetcode.com/problems/reverse-integer/"
    }

    override fun title(): String {
        return "Reverse Integer"
    }

    override fun description(): String {
        return """把一个整数倒过来
            注意：如果倒过来的整数超过了int的表示范围，返回0
        """.trimIndent()
    }

    override fun thinking(): String {
        return ""
    }
}