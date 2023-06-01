/**
 * create by yangliu on 2023/6/1
 * package name :
 */
class Solution74 : Solution() {
    override fun solve() {
        println(searchMatrix(arrayOf(
            intArrayOf(1,3,5,7),
            intArrayOf(10,11,16,20),
            intArrayOf(23,30,34,60),
        ), 3))
    }

    private fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        // 从左上角开始查找
        var row = 0
        var col = matrix[0].size - 1
        while (row < matrix.size && col >= 0) {
            if (matrix[row][col] == target) {
                return true
            } else if (matrix[row][col] < target) {
                row++
            } else {
                col--
            }
        }
        return false
    }

    override fun link(): String {
        return "https://leetcode.com/problems/search-a-2d-matrix/"
    }

    override fun title(): String {
        return "Search a 2D Matrix"
    }

    override fun description(): String {
        return "二维数组查找"
    }

    override fun thinking(): String {
        return ""
    }
}