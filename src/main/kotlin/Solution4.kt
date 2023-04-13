/**
 * create by yangliu on 2023/4/13
 * package name :
 */
class Solution4 : Solution() {
    override fun solve() {
        val nums1 = intArrayOf(1,4)
        val nums2 = intArrayOf(2,3,5)
        println(findMedianSortedArrays1(nums1, nums2))
    }

    /**
     * 归并排序的归并过程 O(m+n)
     */
    fun findMedianSortedArrays1(nums1: IntArray, nums2: IntArray): Double {
        val m = nums1.size
        val n = nums2.size
        // 总数是偶数
        val even  = (m + n) % 2 ==  0
        var index1 = 0
        var index2 = 0
        var stopIndex = (m + n) / 2
        var mid1 = 0
        var mid2 = 0
        while (index1 < m || index2 < n) {
            if (index1 >= m) {
                if (index1 + index2 == stopIndex - 1 && even) {
                    mid1 = nums2[index2]
                } else if (index1 + index2 == stopIndex) {
                    mid2 = nums2[index2]
                    break
                }
                index2++
            } else if (index2 >= n) {
                if (index1 + index2 == stopIndex - 1 && even) {
                    mid1 = nums1[index1]
                } else if (index1 + index2 == stopIndex) {
                    mid2 = nums1[index1]
                    break
                }
                index1++
            } else if (nums1[index1] <= nums2[index2]) {
                if (index1 + index2 == stopIndex - 1 && even) {
                    mid1 = nums1[index1]
                } else if (index1 + index2 == stopIndex) {
                    mid2 = nums1[index1]
                    break
                }
                index1++
            } else {
                if (index1 + index2 == stopIndex - 1 && even) {
                    mid1 = nums2[index2]
                } else if (index1 + index2 == stopIndex) {
                    mid2 = nums2[index2]
                    break
                }
                index2++
            }
        }
        return if (even) (mid1 + mid2) / 2.0 else mid2.toDouble()
    }

    override fun link(): String {
        return "https://leetcode.com/problems/median-of-two-sorted-arrays/"
    }

    override fun title(): String {
        return "Median of Two Sorted Arrays"
    }

    override fun description(): String {
        return """返回两个排序数组的中位数
            |注意：复杂度应该是O(lg(m + n))
        """.trimMargin()
    }

    override fun thinking(): String {
        return """
            * 归并排序的归并过程
              * 时间复杂度 O(m + n)
            * O (lg(m + n))的算法？
        """.trimIndent()
    }
}