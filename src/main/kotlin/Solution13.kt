/**
 * create by yangliu on 2023/4/16
 * package name :
 */
class Solution13 : Solution() {
    override fun solve() {
        println(romanToInt("III"))
        println(romanToInt("LVIII"))
        println(romanToInt("MCMXCIV"))
    }

    private val map = mapOf(
        'I' to 1,
        'V' to 5,
        'X' to 10,
        'L' to 50,
        'C' to 100,
        'D' to 500,
        'M' to 1000
    )

    private fun romanToInt(s: String): Int {
        assert(s.isNotEmpty())
        if (s.length == 1) return map[s[0]]!!
        var result = 0
        for (i in s.indices) {
            if (i + 1 < s.length && map[s[i]]!! < map[s[i + 1]]!!) {
                result -= map[s[i]]!!
            } else {
                result += map[s[i]]!!
            }
        }
        return result
    }

    override fun link(): String {
        return "https://leetcode.com/problems/roman-to-integer/"
    }

    override fun title(): String {
        return "Roman to Integer"
    }

    override fun description(): String {
        return "罗马数转整数"
    }

    override fun thinking(): String {
        return ""
    }
}