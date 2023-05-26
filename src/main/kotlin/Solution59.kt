/**
 * create by yangliu on 2023/5/26
 * package name :
 */
class Solution59 : Solution() {
    override fun solve() {
        println(generateMatrix(3).contentDeepToString())
    }

    private fun generateMatrix(n: Int): Array<IntArray> {
        assert(n > 0)
        var startX = 0
        var startY = 0
        var endX = n - 1
        var endY = n - 1
        var direction = 0
        var result = Array(n) { IntArray(n) }
        var index = 0
        while (index < n * n) {
            when(direction) {
                0 -> {
                    for (j in startX .. endX) {
                        result[startY][j] = ++index
                    }
                    direction = 1
                    startY++
                }
                1 -> {
                    for (j in startY .. endY) {
                        result[j][endX] = ++index
                    }
                    direction = 2
                    endX--
                }
                2 -> {
                    for (j in endX downTo startX) {
                        result[endY][j] = ++index
                    }
                    direction = 3
                    endY--
                }
                3 -> {
                    for (j in endY downTo startY) {
                        result[j][startX] = ++index
                    }
                    direction = 0
                    startX++
                }
            }
        }
        return result
    }

    override fun link(): String {
        return "https://leetcode.com/problems/spiral-matrix-ii/"
    }

    override fun title(): String {
        return "Spiral Matrix II"
    }

    override fun description(): String {
        return "生成螺旋矩阵"
    }

    override fun thinking(): String {
        return ""
    }
}