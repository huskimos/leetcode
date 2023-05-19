/**
 * create by yangliu on 2023/5/19
 * package name :
 */
class Solution46 : Solution() {
    override fun solve() {
        println(permute(intArrayOf(1,2,3)))
    }

    private fun permute(nums: IntArray): List<List<Int>> {
        val result = arrayListOf<List<Int>>()
        if (nums.isNotEmpty()) {
            permute(nums, 0, arrayListOf(), result)
        }
        return result
    }

    private fun permute(
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
            swap(nums, i, index)
            current.add(nums[index])
            permute(nums, index + 1, current, result)
            current.removeAt(current.lastIndex)
            swap(nums, i, index)
        }
    }



    override fun link(): String {
        return "https://leetcode.com/problems/permutations/"
    }

    override fun title(): String {
        return "Permutations"
    }

    override fun description(): String {
        return "没有重复元素的全排列"
    }

    override fun thinking(): String {
        return "递归回溯"
    }
}