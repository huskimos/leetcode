/**
 * create by yangliu on 2023/5/27
 * package name :
 */
class Solution63 : Solution() {
    override fun solve() {
        println(uniquePathsWithObstacles(arrayOf(
            intArrayOf(0,0,0),
            intArrayOf(0,1,0),
            intArrayOf(0,0,0),
        )))
    }

    private fun uniquePathsWithObstacles(obstacleGrid: Array<IntArray>): Int {
        assert(obstacleGrid.isNotEmpty() && obstacleGrid[0].isNotEmpty())
        val m = obstacleGrid.size
        val n = obstacleGrid[0].size
        val dp = Array(m) { IntArray(n) }
        var foundObstacle = false
        for (i in 0 until m) {
            if (!foundObstacle && obstacleGrid[i][0] == 1) foundObstacle = true
            dp[i][0] = if (foundObstacle) 0 else 1
        }
        foundObstacle = false
        for (j in 0 until n) {
            if (!foundObstacle && obstacleGrid[0][j] == 1) foundObstacle = true
            dp[0][j] = if (foundObstacle) 0 else 1
        }
        for (i in 1 until m) {
            for (j in 1 until n) {
                dp[i][j] = if (obstacleGrid[i][j] == 1) 0 else dp[i - 1][j] + dp[i][j - 1]
            }
        }
        return dp[m - 1][n - 1]
    }

    override fun link(): String {
        return "https://leetcode.com/problems/unique-paths-ii/"
    }

    override fun title(): String {
        return "Unique Paths II"
    }

    override fun description(): String {
        return "带障碍物的机器人移动的不同路径数"
    }

    override fun thinking(): String {
        return "二维动态规划"
    }
}