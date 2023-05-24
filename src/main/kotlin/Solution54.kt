/**
 * create by yangliu on 2023/5/24
 * package name :
 */
class Solution54 : Solution() {
    override fun solve() {
        println(spiralOrder(arrayOf(
            intArrayOf(1,2,3),
            intArrayOf(4,5,6),
            intArrayOf(7,8,9)
        )))
    }

    private fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        assert(matrix.isNotEmpty() && matrix[0].isNotEmpty())
        // 0 向左
        // 1 向下
        // 2 向右
        // 3 向上
        var startX = 0
        var endX = matrix[0].size - 1
        var startY = 0
        var endY = matrix.size - 1
        var direction = 0
        val result = arrayListOf<Int>()
        val count = matrix.size * matrix[0].size
        while (result.size < count) {
            when(direction) {
                0 -> {
                    for (i in startX..endX) {
                        result.add(matrix[startY][i])
                    }
                    startY++
                    direction = 1
                }
                1 -> {
                    for (i in startY..endY) {
                        result.add(matrix[i][endX])
                    }
                    endX--
                    direction = 2
                }
                2 -> {
                    for (i in endX downTo startX) {
                        result.add(matrix[endY][i])
                    }
                    endY--
                    direction = 3
                }
                3 -> {
                    for (i in endY downTo startY) {
                        result.add(matrix[i][startX])
                    }
                    startX++
                    direction = 0
                }
            }
        }
        return result
    }

    override fun link(): String {
        return "https://leetcode.com/problems/spiral-matrix/"
    }

    override fun title(): String {
        return "Spiral Matrix"
    }

    override fun description(): String {
        return "螺旋矩阵"
    }

    override fun thinking(): String {
        return ""
    }
}