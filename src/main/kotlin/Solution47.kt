/**
 * create by yangliu on 2023/5/19
 * package name :
 */
class Solution47 : Solution() {
    override fun solve() {
        println(permuteUnique(intArrayOf(1,1,2)))
        println(permuteUnique(intArrayOf(1,3,2)))
        println(permuteUnique(intArrayOf(2,2,1,1)))
    }

    private fun permuteUnique(nums: IntArray): List<List<Int>> {
        val result = arrayListOf<List<Int>>()
        if (nums.isNotEmpty()) {
            permuteUnique(nums, 0, arrayListOf(), result)
        }
        return result
    }

    private fun permuteUnique(
        nums: IntArray,
        index: Int,
        current: MutableList<Int>,
        result: MutableList<List<Int>>
    ) {
        if (index >= nums.size) {
            result.add(ArrayList(current))
            return
        }
        for (i in index until nums.size) {
            // index .. i - 1之间没有出现过nums[i]
            if (i == index || !findInRange(nums, index, i - 1, nums[i])) {
                swap(nums, i, index)
                current.add(nums[index])
                permuteUnique(nums, index + 1, current, result)
                current.removeAt(current.lastIndex)
                swap(nums, i, index)
            }
        }
    }

    private fun findInRange(nums: IntArray, begin: Int, end: Int, target: Int): Boolean {
        for (i in begin..end) {
            if (nums[i] == target) {
                return true
            }
        }
        return false
    }

    override fun link(): String {
        return "https://leetcode.com/problems/permutations-ii/"
    }

    override fun title(): String {
        return "Permutations II"
    }

    override fun description(): String {
        return "带重复元素的全排列"
    }

    override fun thinking(): String {
        return ""
    }
}