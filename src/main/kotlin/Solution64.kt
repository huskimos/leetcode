/**
 * create by yangliu on 2023/5/28
 * package name :
 */
class Solution64 : Solution() {
    override fun solve() {
        println(minPathSum(arrayOf(
            intArrayOf(1,3,1),
            intArrayOf(1,5,1),
            intArrayOf(4,2,1)
        )))
    }

    private fun minPathSum(grid: Array<IntArray>): Int {
        assert(grid.isNotEmpty() && grid[0].isNotEmpty())
        val m = grid.size
        val n = grid[0].size
        val dp = Array(m) { IntArray(n) }
        dp[0][0] = grid[0][0]
        for (i in 1 until m) {
            dp[i][0] = dp[i - 1][0] + grid[i][0]
        }
        for (j in 1 until n) {
            dp[0][j] = dp[0][j - 1] + grid[0][j]
        }
        for (i in 1 until m) {
            for (j in 1 until n) {
                dp[i][j] = grid[i][j] + dp[i - 1][j].coerceAtMost(dp[i][j - 1])
            }
        }
        return dp[m - 1][n - 1]
    }

    override fun link(): String {
        return "https://leetcode.com/problems/minimum-path-sum/"
    }

    override fun title(): String {
        return "Minimum Path Sum"
    }

    override fun description(): String {
        return "最小路径和"
    }

    override fun thinking(): String {
        return "二维平面的动态规划"
    }
}