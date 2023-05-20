/**
 * create by yangliu on 2023/5/20
 * package name :
 */
class Solution49 : Solution() {
    override fun solve() {
        println(groupAnagrams(arrayOf("eat","tea","tan","ate","nat","bat")))
        println(groupAnagrams(arrayOf("")))
        println(groupAnagrams(arrayOf("a")))
    }

    private fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val map = hashMapOf<String, MutableList<String>>()
        for (s in strs) {
            val chars = s.toCharArray()
            chars.sort()
            val key = String(chars)
            map[key] = map.getOrDefault(key, arrayListOf()).apply { add(s) }
        }
        return map.values.toList()
    }

    override fun link(): String {
        return "https://leetcode.com/problems/group-anagrams/"
    }

    override fun title(): String {
        return "Group Anagrams"
    }

    override fun description(): String {
        return "分组Anagram"
    }

    override fun thinking(): String {
        return "HashMap"
    }
}