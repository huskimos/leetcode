import java.util.*

/**
 * create by yangliu on 2023/4/26
 * package name :
 */
class Solution31 : Solution() {
    override fun solve() {
        val nums = intArrayOf(1,2,3)
        for (i in 0..10) {
            nextPermutation(nums)
            println(nums.contentToString())
        }
    }

    private fun nextPermutation(nums: IntArray): Unit {
        assert(nums.isNotEmpty())
        // 从后往前找到最大逆序的位置
        var index = nums.size - 1
        // 找到波峰的位置
        while (index > 0 && nums[index] <= nums[index - 1]) index--
        if (index > 0) {
            val next = nums[index - 1]
            var swapIndex = nums.size - 1
            // 在波峰和波峰右侧找到第一个大于next的值
            while (swapIndex >= index && nums[swapIndex] <= next) swapIndex--
            swap(nums, swapIndex, index - 1)
        }
        nums.reverse(index, nums.size)
    }



    override fun link(): String {
        return "https://leetcode.com/problems/next-permutation/"
    }

    override fun title(): String {
        return "Next Permutation"
    }

    override fun description(): String {
        return "下一个全排列"
    }

    override fun thinking(): String {
        return """
            例如 2 3 2 1 3 2，从后往前找到波峰 3
            在波峰和波峰右侧找的大于波峰左侧1的最小元素，把这两个元素交换 2 3 2 2 3 1
            把波峰和波峰右侧的元素逆置 2 3 2 2 1 3
        """.trimIndent()
    }
}