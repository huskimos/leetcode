/**
 * create by yangliu on 2023/4/23
 * package name :
 */
class Solution26 : Solution() {
    override fun solve() {
        println(removeDuplicates(intArrayOf(1,1,2,2,3,4,4,5,5,5)))
    }


    private fun removeDuplicates(nums: IntArray): Int {
        var index = 0
        for (j in nums.indices) {
            if (j == 0 || nums[j] != nums[j - 1]) {
                nums[index++] = nums[j]
            }
        }
        return index
    }

    override fun link(): String {
        return "https://leetcode.com/problems/remove-duplicates-from-sorted-array/"
    }

    override fun title(): String {
        return "Remove Duplicates from Sorted Array"
    }

    override fun description(): String {
        return "原地删除有序数组的重复元素，元素的相对位置保持不变，返回不重复元素的个数"
    }

    override fun thinking(): String {
        return """
            i表示当前不重复的元素应该插入的位置，初始化为0
            遍历数组，索引为j
                if (j == 0 || nums[j] != nums[j - 1]) {
                    nums[i] = nums[j]
                    i++
                } else continue
        """.trimIndent()
    }
}