/**
 * create by yangliu on 2023/5/8
 * package name :
 */
class Solution40 : Solution() {
    override fun solve() {
        println(combinationSum2(intArrayOf(10,1,2,7,6,1,5), 8))
    }

    private fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
        assert(candidates.isNotEmpty())
        val result = arrayListOf<List<Int>>()
        combinationSum2(candidates.sortedArray(), target, 0, arrayListOf(), result)
        return result
    }

    private fun combinationSum2(
        sorted: IntArray,
        target: Int,
        start: Int,
        current: MutableList<Int>,
        result: MutableList<List<Int>>) {
        if (target == 0) {
            result.add(ArrayList(current))
            return
        }
        if (start >= sorted.size || target < 0) return
        for (i in start until sorted.size) {
            if (i == start || sorted[i] != sorted[i - 1]) {
                current.add(sorted[i])
                combinationSum2(sorted, target - sorted[i], i + 1, current, result)
                // 不选这个数，尝试其他解
                current.removeAt(current.lastIndex)
            }
        }
    }

    override fun link(): String {
        return "https://leetcode.com/problems/combination-sum-ii/"
    }

    override fun title(): String {
        return "Combination Sum II"
    }

    override fun description(): String {
        return """求出和为给定值的所有组合
            |数组中可能有重复元素
            |每个数只能选取一次
        """.trimMargin()
    }

    override fun thinking(): String {
        return """
            先对数组进行排序，如果后一个数和前一个数一样就不用考虑了
            递归回溯
        """.trimIndent()
    }
}