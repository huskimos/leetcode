import kotlin.math.round

/**
 * create by yangliu on 2023/5/25
 * package name :
 */
class Solution57 : Solution() {
    override fun solve() {
        println(insert(arrayOf(
            intArrayOf(1,3),
            intArrayOf(6,9)
        ), intArrayOf(2,5)).contentDeepToString())
    }

    private fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
        if (intervals.isEmpty()) return arrayOf(newInterval)
        // 寻找插入位置O(lgn)
        var left = 0
        var right = intervals.size - 1
        var position = -1
        while (left <= right) {
            val mid = left + (right - left) / 2
            if (intervals[mid][0] == newInterval[0]) {
                position = mid
                break
            } else if (intervals[mid][0] < newInterval[0]) {
                left = mid + 1
            } else {
                right = mid - 1
            }
        }
        if (position == -1) position = left

        val inserted = intervals.toMutableList().apply { add(position, newInterval) }
        val result = arrayListOf<IntArray>()
        for (arr in inserted) {
            if (result.isEmpty()) {
                result.add(arr)
            } else {
                val last = result[result.lastIndex]
                if (arr[0] <= last[1]) {
                    result.removeAt(result.lastIndex)
                    result.add(intArrayOf(last[0], arr[1].coerceAtLeast(last[1])))
                } else {
                    result.add(arr)
                }
            }
        }
        return result.toTypedArray()
    }

    override fun link(): String {
        return "https://leetcode.com/problems/insert-interval/"
    }

    override fun title(): String {
        return "Insert Interval"
    }

    override fun description(): String {
        return "插入区间"
    }

    override fun thinking(): String {
        return ""
    }
}