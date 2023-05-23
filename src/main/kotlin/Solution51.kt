import java.lang.StringBuilder

/**
 * create by yangliu on 2023/5/22
 * package name :
 */
class Solution51 : Solution() {
    override fun solve() {
        println(solveNQueens(4))
    }

    /**
     * 求解N皇后问题
     */
    private fun solveNQueens(n: Int): List<List<String>> {
        val result = arrayListOf<List<String>>()
        val colPlaced = BooleanArray(n) { false }
        val diagonal1Placed = BooleanArray(2 * n - 1) { false }
        val diagonal2Placed = BooleanArray(2 * n - 1) { false }
        solveNQueens(n, 0, IntArray(n), result, colPlaced, diagonal1Placed, diagonal2Placed)
        return result
    }

    /**
     * @param n: 棋盘尺寸
     * @param index: 当前在考察的行数
     * @param current: 当前已经放置好棋子的状况
     * @param result: 结果
     * @param colPlaced 被占据的列
     * @param diagonal1Placed 被占据的对角线1，size为2n-1 左上到右下
     * @param diagonal2Placed 被占据的对角线2，size为2n-1 右上到左下
     */
    private fun solveNQueens(
        n: Int,
        index: Int,
        current: IntArray,
        result: MutableList<List<String>>,
        colPlaced: BooleanArray,
        diagonal1Placed: BooleanArray,
        diagonal2Placed: BooleanArray
    ) {
        if (index >= n) {
            // 生成结果
            val currentResult = arrayListOf<String>()
            for (i in 0 until n) {
                val sb = StringBuilder()
                for (j in 0 until n) {
                    if (current[i] == j) {
                        sb.append("Q")
                    } else {
                        sb.append(".")
                    }
                }
                currentResult.add(sb.toString())
            }
            result.add(currentResult)
            return
        }
        // 当前考察第index行
        for (i in 0 until n) {
            if (!colPlaced[i] && !diagonal1Placed[index - i + n - 1] && !diagonal2Placed[index + i]) {
                // 棋盘上第index行第i列的位置没有被占据
                current[index] = i

                // 修改占据状态
                colPlaced[i] = true
                diagonal1Placed[index - i + n - 1] = true
                diagonal2Placed[index + i] = true

                // 递归
                solveNQueens(n, index + 1, current, result, colPlaced, diagonal1Placed, diagonal2Placed)

                // 回溯
                colPlaced[i] = false
                diagonal1Placed[index - i + n - 1] = false
                diagonal2Placed[index + i] = false
            }
        }
    }

    override fun link(): String {
        return "https://leetcode.com/problems/n-queens/"
    }

    override fun title(): String {
        return "N-Queens"
    }

    override fun description(): String {
        return "N皇后问题"
    }

    override fun thinking(): String {
        return "递归回溯"
    }
}