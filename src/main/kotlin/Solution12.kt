/**
 * create by yangliu on 2023/4/15
 * package name :
 */
class Solution12 : Solution() {
    override fun solve() {
        println(intToRoman(3))
        println(intToRoman(38))
        println(intToRoman(48))
        println(intToRoman(58))
        println(intToRoman(1994))
    }

    private val map = mapOf(
        1 to "I",
        4 to "IV",
        5 to "V",
        9 to "IX",
        10 to "X",
        40 to "XL",
        50 to "L",
        90 to "XC",
        100 to "C",
        400 to "CD",
        500 to "D",
        900 to "CM",
        1000 to "M"
    )
    private val keys = map.keys.toList()
    private fun intToRoman(num: Int): String {
        if (num == 0) return ""
        var index = keys.size - 1
        while (index > 0 && num < keys[index]) {
            index--
        }
        val prefix = map[keys[index]]!!
        return prefix + intToRoman(num - keys[index])
    }

    override fun link(): String {
        return "https://leetcode.com/problems/integer-to-roman/"
    }

    override fun title(): String {
        return "Integer to Roman"
    }

    override fun description(): String {
        return """整数(1 .. 3999)转罗马数""".trimMargin()
    }

    override fun thinking(): String {
        return """
            
        """.trimIndent()
    }
}