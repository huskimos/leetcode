/**
 * create by yangliu on 2023/5/31
 * package name :
 */
class Solution73 : Solution() {
    override fun solve() {
        setZeroes(arrayOf(
            intArrayOf(1,1,1),
            intArrayOf(1,0,1),
            intArrayOf(1,1,1)
        ))
    }

    private fun setZeroes(matrix: Array<IntArray>): Unit {
        assert(matrix.isNotEmpty() && matrix[0].isNotEmpty())
        val settle = Array(matrix.size) { BooleanArray(matrix[0].size) { false } }
        for (i in matrix.indices) {
            for (j in matrix[i].indices) {
                if (matrix[i][j] == 0 && !settle[i][j]) {
                    for (k in matrix[i].indices) {
                        if (matrix[i][k] != 0) {
                            matrix[i][k] = 0
                            settle[i][k] = true
                        }
                    }
                    for (k in matrix.indices) {
                        if (matrix[k][j] != 0) {
                            matrix[k][j] = 0
                            settle[k][j] = true
                        }
                    }
                }
            }
        }
    }

    override fun link(): String {
        return "https://leetcode.com/problems/set-matrix-zeroes/"
    }

    override fun title(): String {
        return "Set Matrix Zeroes"
    }

    override fun description(): String {
        return "设置矩阵的某一行或某一列全为0，要求原地"
    }

    override fun thinking(): String {
        return """
            关键是怎么区分0是一开始就有的，还是运行时设置的：
            1. 最简单的是采用 m * n 的BooleanArray
            2. m + n的？
            3. 常数的？
        """.trimIndent()
    }
}