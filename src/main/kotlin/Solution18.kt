/**
 * create by yangliu on 2023/4/19
 * package name :
 */
class Solution18 : Solution() {
    override fun solve() {
        println(fourSum(intArrayOf(1,0,-1,0,-2,2), 0))
    }

    private fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
        nums.sort()
        return kSum(nums, 0, 4, target.toLong())
    }

    /**
     * nums是有序的数组，从start的位置开始寻找k个数使得他们的和为target
     */
    private fun kSum(nums: IntArray, start: Int, k: Int, target: Long): List<List<Int>> {
        if (start < 0 || start >= nums.size || nums.size - start < k) return emptyList()
        if (k == 1) {
            for (i in start until nums.size) {
                if (nums[i].toLong() == target) {
                    return listOf(listOf(target.toInt()))
                }
            }
            return emptyList()
        }
        val result = arrayListOf<MutableList<Int>>()
        for (i in start until nums.size) {
            if (nums[i] > target / k) break
            if (i > start && nums[i] == nums[i - 1]) continue
            val newTarget = target - nums[i]
            val kMinusOneSum = kSum(nums, i + 1, k - 1, newTarget)
            for (arr in kMinusOneSum) {
                result.add(arrayListOf(nums[i]).apply { addAll(arr) })
            }
        }
        return result
    }

    override fun link(): String {
        return "https://leetcode.com/problems/4sum/"
    }

    override fun title(): String {
        return "4Sum"
    }

    override fun description(): String {
        return "四数之和"
    }

    override fun thinking(): String {
        return "递归"
    }
}