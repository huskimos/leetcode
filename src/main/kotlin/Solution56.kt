/**
 * create by yangliu on 2023/5/25
 * package name :
 */
class Solution56 : Solution() {
    override fun solve() {
        println(merge(arrayOf(
            intArrayOf(1,3),
            intArrayOf(2,6),
            intArrayOf(8,10),
            intArrayOf(15,18)
        )).contentDeepToString())
    }

    private fun merge(intervals: Array<IntArray>): Array<IntArray> {
        assert(intervals.isNotEmpty())
        val result = arrayListOf<IntArray>()
        intervals.sortBy { it[0] }
        for (arr in intervals) {
            if (result.isEmpty()) {
                // 第一个区间
                result.add(arr)
            } else {
                // 取出最后一个区间
                val last = result[result.lastIndex]
                if (arr[0] <= last[1]) {
                    // 可以合并
                    result.removeAt(result.lastIndex)
                    result.add(intArrayOf(last[0], arr[1].coerceAtLeast(last[1])))
                } else {
                    // 不可以合并
                    result.add(arr)
                }
            }
        }
        return result.toTypedArray()
    }

    override fun link(): String {
        return "https://leetcode.com/problems/merge-intervals/"
    }

    override fun title(): String {
        return "Merge Intervals"
    }

    override fun description(): String {
        return "合并区间"
    }

    override fun thinking(): String {
        return """
            先把区间按照起点进行排序，循环中比较当前区间是否可以和之前的区间合并
        """.trimIndent()
    }

}