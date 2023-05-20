/**
 * create by yangliu on 2023/5/20
 * package name :
 */
class Solution48 : Solution() {
    override fun solve() {
        val matrix = arrayOf(
            intArrayOf(1,2,3),
            intArrayOf(4,5,6),
            intArrayOf(7,8,9)
        )
        rotate(matrix)
        println(matrix.contentDeepToString())
    }

    private fun rotate(matrix: Array<IntArray>): Unit {
        assert(matrix.isNotEmpty() && matrix[0].isNotEmpty())
        val cols = matrix[0].size
        // 沿着左上到右下的对角线翻转
        for (i in matrix.indices) {
            for (j in i until cols) {
                // 交换 matrix[i][j] 与 matrix[j][i]
                val temp = matrix[i][j]
                matrix[i][j] = matrix[j][i]
                matrix[j][i] = temp
            }
        }
        // 沿着垂直中轴线翻转
        for (i in matrix.indices) {
            for (j in 0 until cols / 2) {
                // 交换 matrix[i][j] 与 matrix[i][cols - j - 1]
                val temp = matrix[i][j]
                matrix[i][j] = matrix[i][cols - j - 1]
                matrix[i][cols - j - 1] = temp
            }
        }
    }

    override fun link(): String {
        return "https://leetcode.com/problems/rotate-image/"
    }

    override fun title(): String {
        return "Rotate Image"
    }

    override fun description(): String {
        return "旋转图片"
    }

    override fun thinking(): String {
        return "先沿着左上到右下的对角线翻转，再沿着垂直中轴线翻转"
    }
}