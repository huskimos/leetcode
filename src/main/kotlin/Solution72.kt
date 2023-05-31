/**
 * create by yangliu on 2023/5/31
 * package name :
 */
class Solution72 : Solution() {
    override fun solve() {
        println(minDistance("horse", "ros"))
        println(minDistance("intention", "execution"))
    }

    private fun minDistance(word1: String, word2: String): Int {
        if (word1.isEmpty()) return word2.length
        if (word2.isEmpty()) return word1.length
        val dp = Array(word1.length) { IntArray(word2.length) }
        var found = false
        for (j in word2.indices) {
            if (!found) found = word1[0] == word2[j]
            // 如果word2.sunString(0, j + 1)不包含word1[0] 则需要j + 1次操作(j次删除 + 1次替换)
            // 否则只需要j次删除
            dp[0][j] = if (found) j else j + 1
        }
        found = false
        for (i in word1.indices) {
            if (!found) found = word1[i] == word2[0]
            dp[i][0] = if (found) i else i + 1
        }
        for (i in 1 until word1.length) {
            for (j in 1 until word2.length) {
                dp[i][j] = if (word1[i] == word2[j]) dp[i - 1][j - 1] else dp[i - 1][j - 1] + 1
                dp[i][j] = dp[i][j].coerceAtMost(dp[i - 1][j] + 1)
                dp[i][j] = dp[i][j].coerceAtMost(dp[i][j - 1] + 1)
            }
        }
        return dp[word1.length - 1][word2.length - 1]
    }

    override fun link(): String {
        return "https://leetcode.com/problems/edit-distance/"
    }

    override fun title(): String {
        return "Edit Distance"
    }

    override fun description(): String {
        return "最小编辑距离"
    }

    override fun thinking(): String {
        return """
            假设需要把word1转变成word2
            dp[i][j]表示以i,j结尾的两个子串的最小编辑距离，则
            dp[i][j] = minOf(
                if (word1[i] == word[j]) dp[i - 1][j - 1] else dp[i - 1][j - 1] + 1 // 替换一个字符
                dp[i - 1][j] + 1, // 删除一个字符
                dp[i][j - 1] + 1, // 插入一个字符
            )
        """.trimIndent()
    }
}