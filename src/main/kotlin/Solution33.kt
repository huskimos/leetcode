/**
 * create by yangliu on 2023/4/28
 * package name :
 */
class Solution33 : Solution() {
    override fun solve() {
        println(search(intArrayOf(4,5,6,7,0,1,2), 0))
        println(search(intArrayOf(5,1,3), 3))
    }

    private fun search(nums: IntArray, target: Int): Int {
        if (nums.isEmpty()) return -1
        var left = 0
        var right = nums.size - 1
        while (left <= right) {
            val mid = left + (right - left) / 2
            if (nums[mid] == target) return mid
            if (nums[mid] >= nums[left]) {
                // 左半部分有序 nums[mid] >= nums[left] 等号不能掉，否则就遗漏了情况
                if (target >= nums[left] && target <= nums[mid]) {
                    right = mid - 1
                } else {
                    left = mid + 1
                }
            } else {
                // 右半部分有序
                if (target >= nums[mid] && target <= nums[right]) {
                    left = mid + 1
                } else {
                    right = mid - 1
                }
            }
        }
        return -1
    }

    override fun link(): String {
        return "https://leetcode.com/problems/search-in-rotated-sorted-array/"
    }

    override fun title(): String {
        return "Search in Rotated Sorted Array"
    }

    override fun description(): String {
        return "在旋转有序数组中查找，没有重复元素"
    }

    override fun thinking(): String {
        return """
            有序数组旋转之后，以中点划分的话，至少有一半是有序的
            找出有序的一部分判断target是不是在这个区间
            如果不在有序的一部分，就去另一部分找
        """.trimIndent()
    }
}