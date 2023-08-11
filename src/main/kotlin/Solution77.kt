/**
 * create by yangliu on 2023/8/12
 * package name :
 */
class Solution77 : Solution() {
    override fun solve() {
        println(combine(4, 2))
    }

    private fun combine(n: Int, k: Int): List<List<Int>> {
        val result = arrayListOf<List<Int>>()
        combine(n, k, 1, arrayListOf(), result)
        return result
    }

    private fun combine(n: Int, k: Int, index: Int, current: MutableList<Int>, result: MutableList<List<Int>>) {
        if (k == 0) {
            result.add(ArrayList(current))
            return
        }
        for (i in index..(n - k + 1)) {
            // 剪枝
            current.add(i)
            combine(n, k - 1, i + 1, current, result)
            current.removeAt(current.lastIndex);
        }
    }

    override fun link(): String {
        return "https://leetcode.com/problems/combinations/"
    }

    override fun title(): String {
        return "组合数"
    }

    override fun description(): String {
        return ""
    }

    override fun thinking(): String {
        return "递归回溯"
    }
}