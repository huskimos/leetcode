/**
 * create by yangliu on 2023/4/17
 * package name :
 */
class Solution16 : Solution() {
    override fun solve() {
        val nums = intArrayOf(-1,2,1,-4)
        val target = 1
        println(threeSumClosest(nums, target))
    }

    private fun threeSumClosest(nums: IntArray, target: Int): Int {
        assert(nums.size >= 3)
        nums.sort()
        var minDiff = Int.MAX_VALUE
        var closest = 0
        for (i in nums.indices) {
            var l = i + 1
            var r = nums.size - 1
            while (l < r) {
                val sum = nums[l] + nums[r] + nums[i]
                val diff = Math.abs(sum - target)
                if (diff == 0) return target
                if (minDiff > diff) {
                    minDiff = diff
                    closest = sum
                }
                when {
                    sum > target -> r--
                    sum < target -> l++
                }
            }
        }
        return closest
    }

    override fun link(): String {
        return "https://leetcode.com/problems/3sum-closest/"
    }

    override fun title(): String {
        return "3Sum Closest"
    }

    override fun description(): String {
        return "找出最接近target的三数之和"
    }

    override fun thinking(): String {
        return ""
    }
}