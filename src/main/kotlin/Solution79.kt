/**
 * create by yangliu on 2023/8/29
 * package name :
 */
class Solution79 : Solution() {
    override fun solve() {
        val board = arrayOf(
            charArrayOf('A','B','C','E'),
            charArrayOf('S','F','C','S'),
            charArrayOf('A','D','E','E'),
        )
        val word = "ABCCED"
        println(exist(board, word))
    }

    fun exist(board: Array<CharArray>, word: String): Boolean {
        val visited = Array(board.size) { BooleanArray(board[0].size) { false } }
        for (i in board.indices) {
            for (j in board[i].indices) {
                if (dps(board, i, j, word, 0, visited)) {
                    return true
                }
            }
        }
        return false
    }

    private fun dps(board: Array<CharArray>,
                    x: Int,
                    y: Int,
                    word: String,
                    index: Int,
                    visited: Array<BooleanArray>): Boolean {
        if (index >= word.length) return true
        if (x < 0 || x >= board.size || y < 0 || y >= board[0].size) return false
        if (visited[x][y] || board[x][y] != word[index]) return false
        visited[x][y] = true
        val left = dps(board, x - 1, y, word, index + 1, visited)
        val right = dps(board, x + 1, y, word, index + 1, visited)
        val top = dps(board, x , y - 1, word, index + 1, visited)
        val bottom = dps(board, x , y + 1, word, index + 1, visited)
        if (left || right || top || bottom) return true
        visited[x][y] = false
        return false
    }

    override fun link(): String {
        return "https://leetcode.com/problems/word-search/";
    }

    override fun title(): String {
        return "Word Search"
    }

    override fun description(): String {
        return "单词搜索"
    }

    override fun thinking(): String {
        return "递归回溯"
    }
}