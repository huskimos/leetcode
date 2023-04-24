/**
 * create by yangliu on 2023/4/25
 * package name :
 */
class Solution29 : Solution() {
    override fun solve() {
//        println(divide(10, 3))
//        println(divide(7, -3))
        println(divide(-2147483648, -1))
    }

    /**
     * 超时
     */
    private fun divide(dividend: Int, divisor: Int): Int {
        assert(divisor != 0)
        // 转成Long进行运算，防止整型溢出
        val negative = (dividend > 0L && divisor < 0L) || (dividend < 0L && divisor > 0L)
        val absDividend = Math.abs(dividend.toLong())
        val absDivisor = Math.abs(divisor.toLong())
        var result = 0L
        var left = absDividend
        while (left >= absDivisor) {
            left -= absDivisor
            result++
        }
        return if (negative) {
            if (-result < Int.MIN_VALUE) Int.MIN_VALUE else -result.toInt()
        } else {
            if (result > Int.MAX_VALUE) Int.MAX_VALUE else result.toInt()
        }
    }

    override fun link(): String {
        return "https://leetcode.com/problems/divide-two-integers/"
    }

    override fun title(): String {
        return "Divide Two Integers"
    }

    override fun description(): String {
        return "不用乘法除法和模运算求两个整数的商"
    }

    override fun thinking(): String {
        return """
            主要就是要考虑整型溢出和超时
        """.trimIndent()
    }
}