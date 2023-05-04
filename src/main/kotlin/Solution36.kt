/**
 * create by yangliu on 2023/5/4
 * package name :
 */
class Solution36 : Solution() {
    override fun solve() {
        val board = arrayOf(
            charArrayOf('5','3','.','.','7','.','.','.','.'),
            charArrayOf('6','.','.','1','9','5','.','.','.'),
            charArrayOf('.','9','8','.','.','.','.','6','.'),
            charArrayOf('8','.','.','.','6','.','.','.','3'),
            charArrayOf('4','.','.','8','.','3','.','.','1'),
            charArrayOf('7','.','.','.','2','.','.','.','6'),
            charArrayOf('.','6','.','.','.','.','2','8','.'),
            charArrayOf('.','.','.','4','1','9','.','.','5'),
            charArrayOf('.','.','.','.','8','.','.','7','9'),
        )
        println(isValidSudoku(board))
    }

    private fun isValidSudoku(board: Array<CharArray>): Boolean {
        assert(board.size == 9 && board[0].size == 9)
        for (i in board.indices) {
            for (j in board[i].indices) {
                if (board[i][j] != '.') {
                    // 验证行
                    for (k in j + 1 until board[i].size) {
                        if (board[i][j] == board[i][k]) return false
                    }
                    // 验证列
                    for (k in i + 1 until board.size) {
                        if (board[i][j] == board[k][j]) return false
                    }
                    // 验证3*3的方格
                    val gridX = (i / 3) * 3
                    val gridY = (j / 3) * 3
                    for (m in gridX .. gridX + 2) {
                        for (n in gridY .. gridY + 2) {
                            if (m == i && n == j) continue
                            if (board[m][n] == board[i][j]) {
                                return false
                            }
                        }
                    }
                }
            }
        }
        return true
    }

    override fun link(): String {
        return "https://leetcode.com/problems/valid-sudoku/"
    }

    override fun title(): String {
        return "Valid Sudoku"
    }

    override fun description(): String {
        return """有效数独
            |数独可以是有效的但不一定有解
            |只需要验证已经被填出来的数字
        """.trimMargin()

    }

    override fun thinking(): String {
        return ""
    }
}