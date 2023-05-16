/**
 * create by yangliu on 2023/5/16
 * package name :
 */
class Solution42 : Solution() {
    override fun solve() {
        println(trap(intArrayOf(0,1,0,2,1,0,1,3,2,1,2,1)))
        println(trap(intArrayOf(4,2,0,3,2,5)))
    }

    private fun trap(height: IntArray): Int {
        assert(height.isNotEmpty())
        val leftMax = IntArray(height.size)
        val rightMax = IntArray(height.size)
        leftMax[0] = height[0]
        rightMax[height.size - 1] = height[height.size - 1]
        for (i in 1 until height.size) {
            leftMax[i] = height[i].coerceAtLeast(leftMax[i - 1])
        }
        for (j in height.size - 2 downTo 0) {
            rightMax[j] = height[j].coerceAtLeast(rightMax[j + 1])
        }
        var result = 0
        for (i in height.indices) {
            result += leftMax[i].coerceAtMost(rightMax[i]) - height[i]
        }
        return result
    }

    override fun link(): String {
        return "https://leetcode.com/problems/trapping-rain-water/"
    }

    override fun title(): String {
        return "Trapping Rain Water"
    }

    override fun description(): String {
        return "接雨水"
    }

    override fun thinking(): String {
        return "找出每个位置的左边最高处和右边最高处，动态规划"
    }
}