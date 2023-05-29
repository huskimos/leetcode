/**
 * create by yangliu on 2023/5/29
 * package name :
 */
class Solution70 : Solution() {
    override fun solve() {
        println(climbStairs(1))
        println(climbStairs(2))
        println(climbStairs(3))
        println(climbStairs(4))
    }

    private fun climbStairs(n: Int): Int {
        if (n == 1) return 1
        if (n == 2) return 2
        val dp = IntArray(n)
        dp[0] = 1
        dp[1] = 2
        for (i in 2 until n) {
            dp[i] = dp[i - 1] + dp[i - 2]
        }
        return dp[n - 1]
    }

    override fun link(): String {
        return "https://leetcode.com/problems/climbing-stairs/"
    }

    override fun title(): String {
        return "Climbing Stairs"
    }

    override fun description(): String {
        return "爬梯子"
    }

    override fun thinking(): String {
        return "斐波那契数列"
    }
}