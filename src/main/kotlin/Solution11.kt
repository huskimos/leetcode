/**
 * create by yangliu on 2023/4/15
 * package name :
 */
class Solution11 : Solution() {
    override fun solve() {
        println(maxArea(intArrayOf(1,8,6,2,5,4,8,3,7)))
    }

    /**
     * 找出围成的最大矩形的面积
     */
    private fun maxArea(height: IntArray): Int {
        assert(height.size >= 2)
        var left = 0
        var right = height.size - 1
        var max = 0
        while (left < right) {
            // 当前left -- right构成的面积
            val area = height[left].coerceAtMost(height[right]) * (right - left)
            max = max.coerceAtLeast(area)
            if (height[left] < height[right]) {
                left++
            } else {
                right--
            }
        }
        return max
    }

    override fun link(): String {
        return "https://leetcode.com/problems/container-with-most-water/"
    }

    override fun title(): String {
        return "Container With Most Water"
    }

    override fun description(): String {
        return """可以容纳最水的容器
            |给出一个整数数组，代表高度，x轴代表上索引差的绝对值代表底，求出最大面积
        """.trimIndent()
    }

    override fun thinking(): String {
        return """
            对撞指针，移动两个端点中较长的边不会导致矩形区域面积的增加
            """.trimIndent()
    }
}