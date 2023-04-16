/**
 * create by yangliu on 2023/4/16
 * package name :
 */
class Solution15 : Solution() {
    override fun solve() {
        println(threeSum(intArrayOf(-1,0,1,2,-1,-4)))
//        println(threeSum(intArrayOf(0,1,1)))
//        println(threeSum(intArrayOf(0,0,0)))
    }

    override fun link(): String {
        return "https://leetcode.com/problems/3sum/"
    }

    private fun threeSum(nums: IntArray): List<List<Int>> {
        val result = arrayListOf<MutableList<Int>>()
        nums.sort()
        for (i in nums.indices) {
            if (nums[i] > 0) break
            if (i > 0 && nums[i] == nums[i - 1]) continue
            val target = -nums[i]
            val twoSums = twoSum(nums, target, i + 1)
            if (twoSums.isNotEmpty()) {
                for (t in twoSums) {
                    val current = arrayListOf(nums[i])
                    current.addAll(t)
                    result.add(current)
                }
            }
        }
        return result
    }

    private fun twoSum(nums: IntArray, target: Int, start: Int): List<List<Int>> {
        // nums是有序的数组
        if (start >= nums.size - 1) return emptyList()
        var left = start
        var right = nums.size - 1
        val result = arrayListOf<List<Int>>()
        while (left < right) {
            val sum = nums[left] + nums[right]
            if (sum < target) {
                left++
            } else if (sum > target){
                right--
            } else {
                val currentLeft = nums[left]
                val currentRight = nums[right]
                result.add(listOf(currentLeft, currentRight))
                // 跳过重复元素
                while (left < nums.size && nums[left] == currentLeft) left++
                while (right >= 0 && nums[right] == currentRight) right--
            }
        }
        return result
    }

    override fun title(): String {
        return "3Sum"
    }

    override fun description(): String {
        return "给出一个整数数组，找出所有三数之和等于0的组合"
    }

    override fun thinking(): String {
        return """
            以[-1,0,1,2,-1,-4]举例
            首先先对数组进行排序
            得到[-4,-1,-1,0,1,2]
            对排序后的数组进行遍历
                * 如果当前遍历到的数大于0，则不再可能存在解
                * 如果当前遍历到的数和前一个元素相同，则是重复解，继续循环
                * 否则在后面的数中寻找两数之和等于当前遍历到的数的相反数
        """.trimIndent()
    }
}