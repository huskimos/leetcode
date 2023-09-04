/**
 * create by yangliu on 2023/9/4
 * package name :
 */
class Solution80 : Solution() {
    override fun solve() {
        println(removeDuplicates(intArrayOf(1,2,3,4,5)))
    }

    private fun removeDuplicates(nums: IntArray): Int {
        if (nums.size <= 2) return nums.size
        // i是当前正在考察的元素索引，j是处理之后的下一个元素应该在的位置
        var current = nums[0]
        var j = 1
        var count = 1
        for (i in 1 until nums.size) {
            if (nums[i] != current) {
                // 碰到新的元素，交换
                current = nums[i]
                count = 1
                if (i != j) {
                    swap(nums, i, j)
                }
                j++
            } else {
                count++
                if (count == 2) {
                    // 碰到第二个
                    if (i != j) {
                        swap(nums, i, j)
                    }
                    j++
                }
            }
        }
        return j
    }

    override fun link(): String {
        return "https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/"
    }

    override fun title(): String {
        return "Remove Duplicates from Sorted Array II"
    }

    override fun description(): String {
        return """
            从有序数组中移除重复元素2
            原地算法使得移除之后每个元素最多出现两次
        """.trimIndent()

    }

    override fun thinking(): String {
        return "双指针"
    }
}