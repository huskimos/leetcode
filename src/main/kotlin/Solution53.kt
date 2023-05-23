/**
 * create by yangliu on 2023/5/23
 * package name :
 */
class Solution53 : Solution() {
    override fun solve() {
        println(maxSubArray(intArrayOf(-2,1,-3,4,-1,2,1,-5,4)))
        println(maxSubArray(intArrayOf(1)))
        println(maxSubArray(intArrayOf(5,4,-1,7,8)))
    }

    private fun maxSubArray(nums: IntArray): Int {
        if (nums.isEmpty()) return 0
        val dp = IntArray(nums.size)
        dp[0] = nums[0]
        for (i in 1 until nums.size) {
            dp[i] = if (dp[i - 1] > 0) dp[i - 1] + nums[i] else nums[i]
        }
        var max = Int.MIN_VALUE
        for (i in dp) {
            max = max.coerceAtLeast(i)
        }
        return max
    }

    override fun link(): String {
        return "https://leetcode.com/problems/maximum-subarray/"
    }

    override fun title(): String {
        return "Maximum Subarray"
    }

    override fun description(): String {
        return "最大子数组和"
    }

    override fun thinking(): String {
        return "动态规划"
    }
}