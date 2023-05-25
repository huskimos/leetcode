/**
 * create by yangliu on 2023/5/25
 * package name :
 */
class Solution55 : Solution() {
    override fun solve() {
        println(canJump(intArrayOf(2,3,1,1,4)))
        println(canJump(intArrayOf(3,2,1,0,4)))
    }

    private fun canJump(nums: IntArray): Boolean {
        if (nums.isEmpty()) return true
        val dp = BooleanArray(nums.size)
        dp[0] = true
        outer@for (i in 1 until nums.size) {
            for (j in i downTo 1) {
                if (dp[i - j] && nums[i - j] >= j) {
                    dp[i] = true
                    continue@outer
                }
            }
            dp[i] = false
        }
        return dp[nums.size - 1]
    }

    override fun link(): String {
        return "https://leetcode.com/problems/jump-game/"
    }

    override fun title(): String {
        return "Jump Game"
    }

    override fun description(): String {
        return "跳跃游戏"
    }

    override fun thinking(): String {
        return """
            动态规划
            dp[i]表示能不能到i的位置
            dp[i] = any {dp[i - j] && nums[i - j] >= j}
        """.trimIndent()
    }
}