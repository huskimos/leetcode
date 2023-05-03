/**
 * create by yangliu on 2023/5/3
 * package name :
 */
class Solution35 : Solution() {
    override fun solve() {
        println(searchInsert(intArrayOf(1,3,5,6), 5))
    }

    private fun searchInsert(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size - 1
        while (left <= right) {
            val mid = left + (right - left) / 2
            if (nums[mid] == target) return mid
            if (nums[mid] > target) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        return left
    }

    override fun link(): String {
        return "https://leetcode.com/problems/search-insert-position/"
    }

    override fun title(): String {
        return "Search Insert Position"
    }

    override fun description(): String {
        return "寻找插入位置"
    }

    override fun thinking(): String {
        return "二分查找"
    }
}