import java.lang.StringBuilder

/**
 * create by yangliu on 2023/4/13
 * package name :
 */
class Solution6 : Solution() {
    override fun solve() {
        println(convert("PAYPALISHIRING", 3))
    }

    private fun convert(s: String, numRows: Int): String {
        if (numRows == 1) return s
        val div = s.length / (2 * numRows - 2) * (numRows - 1)
        val left = s.length % (2 * numRows - 2)
        val numCols = (if (left <= numRows) 1 else left - numRows + 1) + div
        val matrix = Array(numRows) { CharArray(numCols) { '#' } }
        var direction = 0
        var i = 0
        var j = 0
        for (c in s) {
            if (direction == 0) {
                if (i < numRows) {
                    matrix[i][j] = c
                    if (i == numRows - 1) {
                        // 即将向右上
                        direction = 1
                        i--
                        j++
                    } else {
                        // 向下
                        i++
                    }
                }
            } else if (direction == 1) {
                if (i >= 0) {
                    matrix[i][j] = c
                    if (i == 0) {
                        // 即将向下
                        direction = 0
                        i++
                    } else {
                        // 向右上
                        i--
                        j++
                    }
                }
            }
        }
        val sb = StringBuilder()
        for (m in 0 until numRows) {
            for (n in 0 until numCols) {
                if (matrix[m][n] != '#') {
                    sb.append(matrix[m][n])
                }
            }
        }
        return sb.toString()
    }

    override fun link(): String {
        return "https://leetcode.com/problems/zigzag-conversion/"
    }

    override fun title(): String {
        return "Zigzag Conversion"
    }

    override fun description(): String {
        return "把字符串进行Z字转换"
    }

    override fun thinking(): String {
        return ""
    }
}