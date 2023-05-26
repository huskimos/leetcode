import java.lang.StringBuilder

/**
 * create by yangliu on 2023/5/26
 * package name :
 */
class Solution60 : Solution() {
    override fun solve() {
        println(getPermutation(3, 3))
        println(getPermutation(4, 9))
        println(getPermutation(3, 1))
    }

    private fun getPermutation(n: Int, k: Int): String {
        assert(n > 0)
        val chars = CharArray(n) { '1' + it }
        val allPermutations = arrayListOf<String>()
        getAllPermutations(chars, 0, arrayListOf(), allPermutations)
        allPermutations.sort()
        return allPermutations[k - 1]
    }

    private fun getAllPermutations(
        chars: CharArray,
        index: Int,
        current: MutableList<Char>,
        result: MutableList<String>
    ) {
        if (index >= chars.size) {
            result.add(String(current.toCharArray()))
            return
        }
        for(i in index until chars.size) {
            swap(chars, i, index)
            current.add(chars[index])
            getAllPermutations(chars, index + 1, current, result)
            current.removeAt(current.lastIndex)
            swap(chars, i, index)
        }
    }



    override fun link(): String {
        return "https://leetcode.com/problems/permutation-sequence/"
    }

    override fun title(): String {
        return "Permutation Sequence"
    }

    override fun description(): String {
        return "第k个全排列"
    }

    override fun thinking(): String {
        return """
            暴力解法：先求出所有的全排列，再排序，在取第k个
        """.trimIndent()
    }
}