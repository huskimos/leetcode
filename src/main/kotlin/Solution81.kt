/**
 * create by yangliu on 2023/9/6
 * package name :
 */
class Solution81 : Solution() {
    override fun solve() {
        println(search(intArrayOf(2,5,6,0,0,1,2), 0))
        println(search(intArrayOf(2,5,6,0,0,1,2), 3))
    }


    private fun search(nums: IntArray, target: Int): Boolean {
        var left = 0
        var right = nums.size - 1
        while (left <= right) {
            val mid = left + (right - left).shr(1)
            if (nums[mid] == target) return true
            if (nums[left] == nums[mid] && nums[mid] == nums[right]) {
                left++
                right--
                continue
            }
            if (nums[left] <= nums[mid]) {
                // 左半部分有序
                if (target <= nums[mid] && target >= nums[left]) {
                    // 在有序部分
                    right = mid - 1
                } else {
                    left = mid + 1
                }
            } else {
                // 右半部分有序
                if (target >= nums[mid] && target <= nums[right]) {
                    // 在有序部分
                    left = mid + 1
                } else {
                    right = mid - 1
                }
            }
        }
        return false
    }

    override fun link(): String {
        return "https://leetcode.com/problems/search-in-rotated-sorted-array-ii/"
    }

    override fun title(): String {
        return "Search in Rotated Sorted Array II"
    }

    override fun description(): String {
        return """
            在旋转之后的有序数组中查找
        """.trimIndent()
    }

    override fun thinking(): String {
        return """
            二分查找
        """.trimIndent()
    }
}