/**
 * create by yangliu on 2023/4/11
 * package name :
 */
class Solution1 : Solution() {
    override fun solve() {
        println(twoSum(intArrayOf(2,7,11,15), 9).contentToString())
    }

    private fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = hashMapOf<Int, Int>()
        for (i in nums.indices) {
            val another = map[target - nums[i]]
            if (another != null) {
                return intArrayOf(another, i)
            } else {
                map[nums[i]] = i
            }
        }
        return intArrayOf()
    }

    override fun link(): String {
        return "https://leetcode.com/problems/two-sum/"
    }

    override fun title(): String {
        return "Two Sum"
    }

    override fun description(): String {
        return """给出一个整数数组`nums` 和一个目标整数 `target`，找出两个数字的索引使得他们的和为`target`
            |注意：
            |* 你可以假设只有一个解
            |* 你不能使用同一个数字两次
            |* 可以以任意顺序返回索引
        """.trimMargin()
    }

    override fun thinking(): String {
        return """
          * 暴力解法：两层循环
            * 时间复杂度 O(n ^ 2) 空间复杂度 O(1)
          * Hashmap查找：
            * map存储<nums[i], i>
            * 遍历数组，假设当前索引为i
                1. 如果map不包含target - nums[i]的key，则map[nums[i]] = i
                2. 否则，则找到了唯一解
            * 时间复杂度 O(n), 空间复杂度 O(n)
        """.trimIndent()
    }
}