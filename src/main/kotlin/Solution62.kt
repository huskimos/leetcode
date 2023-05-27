/**
 * create by yangliu on 2023/5/27
 * package name :
 */
class Solution62 : Solution() {
    override fun solve() {
        println(uniquePaths(3, 7))
    }

    private fun uniquePaths(m: Int, n: Int): Int {
        assert(m > 0 && n > 0)
        // dp[i][j]表示到i，j的唯一路径的条数
        val dp = Array(m) { IntArray(n) }
        for (i in 0 until m) {
            dp[i][0] = 1
        }
        for (j in 0 until n) {
            dp[0][j] = 1
        }
        for (i in 1 until m) {
            for (j in 1 until n) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
            }
        }
        return dp[m - 1][n - 1]
    }

    override fun link(): String {
        return "https://leetcode.com/problems/unique-paths/"
    }

    override fun title(): String {
        return "Unique Paths"
    }

    override fun description(): String {
        return "机器人移动的不同路径数"
    }

    override fun thinking(): String {
        return "二维动态规划"
    }
}