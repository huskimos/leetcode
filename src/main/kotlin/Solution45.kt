/**
 * create by yangliu on 2023/5/18
 * package name :
 */
class Solution45 : Solution() {
    override fun solve() {
        println(jump(intArrayOf(2,3,1,1,4)))
        println(jump(intArrayOf(2,3,0,1,4)))
        println(jump(intArrayOf(5,9,3,2,1,0,2,3,3,1,0,0)))
    }

    private fun jump(nums: IntArray): Int {
        val dp = IntArray(nums.size) { -1 }
        dp[0] = 0
        for (i in 1 until nums.size) {
            var curMin = Int.MAX_VALUE
            for (j in 1..i) {
                if (nums[i - j] >= j) {
                    curMin = curMin.coerceAtMost(dp[i - j] + 1)
                }
            }
            if (curMin == Int.MAX_VALUE) return -1
            dp[i] = curMin
        }
        return dp[nums.size - 1]
    }

    override fun link(): String {
        return "https://leetcode.com/problems/jump-game-ii/"
    }

    override fun title(): String {
        return "Jump Game II"
    }

    override fun description(): String {
        return """跳跃游戏2
            给出一个整数数组，初始在位置为0的位置，num[i]表示可以跳跃的步数
            求出最少的步数，用例保证一定有解
        """.trimIndent()
    }

    override fun thinking(): String {
        return """
            记忆化搜索或者动态规划
            dp[i] = min(dp[i - j] + 1) if (num[i - j] >= j)
        """.trimIndent()
    }
}