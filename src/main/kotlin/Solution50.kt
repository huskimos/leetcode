/**
 * create by yangliu on 2023/5/22
 * package name :
 */
class Solution50 : Solution() {
    override fun solve() {
        println(myPow(2.0, 10))
        println(myPow(2.1, 3))
        println(myPow(2.0, -2))
    }

    private fun myPow(x: Double, n: Int): Double {
        if (x == 1.0) return 1.0
        if (x == 0.0) return 0.0
        if (n == 0) return 1.0
        val negative = n < 0
        if (n == Int.MAX_VALUE) {
            return if (Math.abs(x) > 1.0) {
                Double.MAX_VALUE
            } else {
                0.0
            }
        } else if (n == Int.MIN_VALUE) {
            return if (Math.abs(x) > 1.0) {
                Double.MAX_VALUE
            } else {
                0.0
            }
        }
        var e = if (negative) -n else n
        val dp = DoubleArray(e + 1) { 1.0 }
        dp[0] = 1.0
        dp[1] = x
        for (i in 2..e) {
            dp[i] = dp[i/2] * dp[i/2]
            if (i % 2 == 1) {
                dp[i] *= x
            }
        }
        val result = dp[e]
        return if (negative) 1 / result else result
    }

    override fun link(): String {
        return "https://leetcode.com/problems/powx-n/"
    }

    override fun title(): String {
        return " Pow(x, n)"
    }

    override fun description(): String {
        return "实现pow方法"
    }

    override fun thinking(): String {
        return ""
    }
}