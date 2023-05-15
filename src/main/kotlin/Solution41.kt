/**
 * create by yangliu on 2023/5/14
 * package name :
 */
class Solution41 : Solution() {
    override fun solve() {
        println(firstMissingPositive(intArrayOf(1)))
        println(firstMissingPositive(intArrayOf(1,2)))
        println(firstMissingPositive(intArrayOf(1,2,0)))
        println(firstMissingPositive(intArrayOf(3,4,-1,1)))
        println(firstMissingPositive(intArrayOf(7,8,9,11,12)))
        println(firstMissingPositive(intArrayOf(1, 1)))
    }

    private fun firstMissingPositive(nums: IntArray): Int {
        if (nums.isEmpty()) return 1
        var index = 0
        while (index < nums.size) {
            if (nums[index] - 1 >= 0 && nums[index] - 1 < nums.size) {
                if (nums[nums[index] - 1] != nums[index]) {
                    // 交换index和nums[index]，交换之后应该继续考察当前元素
                    swap(nums, index, nums[index] - 1)
                } else {
                    index++
                }
            } else {
                index++
            }
        }
        index = 0
        while (index < nums.size) {
            if (nums[index] != index + 1) {
                return index + 1
            }
            index++
        }
        return index + 1
    }

    override fun link(): String {
        return "https://leetcode.com/problems/first-missing-positive/"
    }

    override fun title(): String {
        return "First Missing Positive"
    }

    override fun description(): String {
        return """第一个丢失的正数
            无序整数数组（可能有负数），要求O(n)的时间和常数空间
        """.trimIndent()
    }

    override fun thinking(): String {
        return """
            从左到右遍历数组，如果nums[i] - 1 >= 0 && nums[i] - 1 < nums.size
            如果nums[i]的位置不是nums[i] - 1，即nums[nums[i] - 1] != nums[i]，则把nums[i]和nums[nums[i] - 1]交换
            碰到负数或者重复的元素直接跳过
        """.trimIndent()
    }
}