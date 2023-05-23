/**
 * create by yangliu on 2023/5/23
 * package name :
 */
class Solution52 : Solution() {
    override fun solve() {
        println(totalNQueens(4))
    }

    private var count = 0

    private fun totalNQueens(n: Int): Int {
        count = 0
        totalNQueens(n, 0, BooleanArray(n), BooleanArray(2*n+1), BooleanArray(2*n+1))
        return count
    }

    private fun totalNQueens(
        n: Int,
        index: Int,
        colPlaced: BooleanArray,
        diagonal1Places: BooleanArray,
        diagonal2Places: BooleanArray
    ) {
        if (index >= n) {
            count++
            return
        }
        for (i in 0 until n) {
            if (!colPlaced[i] && !diagonal1Places[index - i  + n - 1] && !diagonal2Places[index + i]) {
                colPlaced[i] = true
                diagonal1Places[index - i  + n - 1] = true
                diagonal2Places[index + i] = true
                totalNQueens(n, index + 1, colPlaced, diagonal1Places, diagonal2Places)
                colPlaced[i] = false
                diagonal1Places[index - i  + n - 1] = false
                diagonal2Places[index + i] = false
            }
        }
    }

    override fun link(): String {
        return "https://leetcode.com/problems/n-queens-ii/"
    }

    override fun title(): String {
        return "N-Queens II"
    }

    override fun description(): String {
        return "N皇后问题解数"
    }

    override fun thinking(): String {
        return "递归回溯"
    }
}