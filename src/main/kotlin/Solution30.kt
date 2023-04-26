/**
 * create by yangliu on 2023/4/26
 * package name :
 */
class Solution30 : Solution() {
    override fun solve() {
        println(findSubstring("barfoofoobarthefoobarman", arrayOf("bar","foo","the")))
    }

    private fun findSubstring(s: String, words: Array<String>): List<Int> {
        assert(words.isNotEmpty())
        val wordsFreq = hashMapOf<String, Int>()
        for (w in words) {
            wordsFreq[w] = wordsFreq.getOrDefault(w, 0) + 1
        }
        val wordLen = words[0].length
        val parts = arrayListOf<String>()
        for (i in 0..s.length - wordLen) {
            parts.add(s.substring(i, i + wordLen))
        }
        val result = arrayListOf<Int>()
        outer@ for (i in 0..s.length - wordLen) {
            val copy = wordsFreq.deepCopy()
            for (j in words.indices) {
                if (i + j * wordLen >= parts.size) break@outer // 已经不可能有解了
                val current = parts[i + j * wordLen]
                if (!copy.containsKey(current) || copy[current] == 0) continue@outer
                copy[current] = copy[current]!! - 1
            }
            result.add(i)
        }
        return result
    }

    private fun <K, V> HashMap<K, V>.deepCopy(): HashMap<K, V> {
        val copy = hashMapOf<K, V>()
        for ((k, v) in this) {
            copy[k] = v
        }
        return copy
    }

    override fun link(): String {
        return "https://leetcode.com/problems/substring-with-concatenation-of-all-words/"
    }

    override fun title(): String {
        return "Substring with Concatenation of All Words"
    }

    override fun description(): String {
        return "由所有单词排列成的子串"
    }

    override fun thinking(): String {
        return ""
    }
}