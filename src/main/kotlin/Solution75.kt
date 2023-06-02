/**
 * create by yangliu on 2023/6/2
 * package name :
 */
class Solution75 : Solution() {
    override fun solve() {
        val array = intArrayOf(2,0,2,1,1,0)
        sortColors(array)
        println(array.contentToString())
    }

    private fun sortColors(nums: IntArray): Unit {
        var lt = -1
        var gt = nums.size
        var index = 0
        while (index < gt) {
            when(nums[index]) {
                0 -> { swap(nums, index++, ++lt) }
                1 -> { index++ }
                2 -> { swap(nums, index, --gt) }
            }
        }
    }

    override fun link(): String {
        return "https://leetcode.com/problems/sort-colors/"
    }

    override fun title(): String {
        return "Sort Colors"
    }

    override fun description(): String {
        return "颜色排序，要求原地"
    }

    override fun thinking(): String {
        return """
            类似于三路快排的划分
            0 .. lt ..i .. gt ..n - 1
        """.trimIndent()
    }
}