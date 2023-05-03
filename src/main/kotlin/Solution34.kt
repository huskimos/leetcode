/**
 * create by yangliu on 2023/5/3
 * package name :
 */
class Solution34 : Solution() {
    override fun solve() {
//        println(searchRange(intArrayOf(5,7,7,8,8,10), 6).contentToString())
//        println(searchRange(intArrayOf(), 6).contentToString())
        println(searchRange(intArrayOf(6), 6).contentToString())
    }

    private fun searchRange(nums: IntArray, target: Int): IntArray {
        val result = intArrayOf(-1, -1)
        var left = 0
        var right = nums.size - 1
        while (left <= right) {
            val mid = left + (right - left) / 2
            if (nums[mid] == target) {
                // 往前查找
                var index = mid
                while (index >= 0 && nums[index] == target) index--
                result[0] = index + 1
                index = mid
                while (index < nums.size && nums[index] == target) index++
                result[1] = index - 1
                break
            } else if (nums[mid] > target) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        return result
    }

    override fun link(): String {
        return "https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/"
    }

    override fun title(): String {
        return "Find First and Last Position of Element in Sorted Array"
    }

    override fun description(): String {
        return "在一个有序数组中找到一个元素出现的第一个和最后一个位置"
    }

    override fun thinking(): String {
        return "二分查找"
    }
}