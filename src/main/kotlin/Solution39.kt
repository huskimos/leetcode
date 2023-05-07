import kotlin.math.max

/**
 * create by yangliu on 2023/5/7
 * package name :
 */
class Solution39 : Solution() {
    override fun solve() {
        println(combinationSum(intArrayOf(2,3,6,7), 7))
    }

    private fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        val result = arrayListOf<List<Int>>()
        if (candidates.isNotEmpty()) {
            combinationSum(candidates, 0, target, arrayListOf(), result)
        }
        return result
    }

    private fun combinationSum(
        candidates: IntArray,
        start: Int,
        target: Int,
        current: MutableList<Int>,
        result: MutableList<List<Int>>
    ) {
        if (target == 0) {
            // 注意这里要拷贝
            result.add(ArrayList(current))
            return
        }
        if (start >= candidates.size || target < 0) return
        val maxInclude = target / candidates[start]
        for (i in 0..maxInclude) {
            for (k in 0 until i) {
                current.add(candidates[start])
            }
            combinationSum(candidates, start + 1, target - i * candidates[start], current, result)
            for (k in 0 until i) {
                // 回溯
                current.removeAt(current.lastIndex)
            }
        }
    }

    override fun link(): String {
        return "https://leetcode.com/problems/combination-sum/"
    }

    override fun title(): String {
        return "Combination Sum"
    }

    override fun description(): String {
        return """求出和为给定值的所有组合
            1. 给出的数组中没有重复元素
            2. 组合不能重复
            3. 可以以任意顺序返回
            4. 每个数字都可以被重复使用
            5. 数组中的元素都是正数
        """.trimIndent()
    }

    override fun thinking(): String {
        return """
            递归，考察每个元素出现的次数
        """.trimIndent()
    }
}