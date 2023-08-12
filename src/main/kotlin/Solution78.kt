/**
 * create by yangliu on 2023/8/12
 * package name :
 */
class Solution78 : Solution() {
    override fun solve() {
        println(subsets(intArrayOf(1,2,3)))
    }

    private fun subsets(nums: IntArray): List<List<Int>> {
        val result = arrayListOf<List<Int>>()
        for (i in 0..nums.size) {
            combine(nums, i, 0, arrayListOf(), result);
        }
        return result
    }
    private fun combine(
        nums: IntArray,
        k: Int,
        start: Int,
        current: MutableList<Int>,
        result: MutableList<List<Int>>
    ) {
        if (k == 0) {
            result.add(ArrayList(current))
            return
        }
        for (i in start until nums.size - k + 1) {
            current.add(nums[i])
            combine(nums, k - 1, i + 1, current, result);
            current.removeAt(current.lastIndex)
        }
    }

    override fun link(): String {
        return "https://leetcode.com/problems/subsets/"
    }

    override fun title(): String {
        return "子集"
    }

    override fun description(): String {
        return "给出一个没有重复元素的集合，求全部的子集"
    }

    override fun thinking(): String {
        return "组合数的扩展？"
    }
}