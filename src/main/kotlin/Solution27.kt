/**
 * create by yangliu on 2023/4/23
 * package name :
 */
class Solution27 : Solution() {
    override fun solve() {
        println(removeElement(intArrayOf(1,3,2,3), 3))
    }

    private fun removeElement(nums: IntArray, `val`: Int): Int {
        var index = 0
        var end = nums.size
        while (index < end) {
            if (nums[index] == `val`) {
                nums[index] = nums[--end]
            } else {
                index++
            }
        }
        return end
    }

    override fun link(): String {
        return "https://leetcode.com/problems/remove-element/"
    }

    override fun title(): String {
        return "Remove Element"
    }

    override fun description(): String {
        return "移除数组的某个元素，元素顺序可以被修改"
    }

    override fun thinking(): String {
        return ""
    }
}