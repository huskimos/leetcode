/**
 * create by yangliu on 2023/5/5
 * package name :
 */
class Solution37 : Solution() {
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
        solveSudoku(board)
        println("end")
    }

    private fun solveSudoku(board: Array<CharArray>) {
        solveSudokuInternal(board)
    }

    private fun solveSudokuInternal(board: Array<CharArray>): Boolean {
        assert(board.size == 9 && board[0].size == 9)
        for (i in board.indices) {
            for (j in board[i].indices) {
                if (board[i][j] == '.') {
                    tryOnce@for (m in '1'..'9') {
                        // 检查行
                        for (k in board.indices) {
                            if (board[i][k] == m) {
                                continue@tryOnce
                            }
                        }
                        // 检查列
                        for (k in board[i].indices) {
                            if (board[k][j] == m) {
                                continue@tryOnce
                            }
                        }
                        // 检查3*3方格
                        val gridX = (i / 3) * 3
                        val gridY = (j / 3) * 3
                        for (p in gridX..gridX + 2) {
                            for (q in gridY..gridY + 2) {
                                if (board[p][q] == m) {
                                    continue@tryOnce
                                }
                            }
                        }
                        board[i][j] = m
                        if (solveSudokuInternal(board)) {
                            return true
                        }
                        board[i][j] = '.'
                    }
                    // 所有数字都尝试了，无解
                    return false
                }
            }
        }
        // 得解
        return true
    }


    override fun link(): String {
        return "https://leetcode.com/problems/sudoku-solver/"
    }

    override fun title(): String {
        return "Sudoku Solver"
    }

    override fun description(): String {
        return "解决数独"
    }

    override fun thinking(): String {
        return """
            递归回溯:
            1. 
        """.trimIndent()
    }
}