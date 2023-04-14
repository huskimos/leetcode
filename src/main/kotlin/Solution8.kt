/**
 * create by yangliu on 2023/4/14
 * package name :
 */
class Solution8 : Solution() {
    override fun solve() {
//        println(myAtoi("   -42"))
//        println(myAtoi("     -429999999999999"))
//        println(myAtoi(" - 1  af 432 white world"))
//        println(myAtoi("words and 987"))
//        println(myAtoi("words +33and 987"))
        println(myAtoi("9223372036854775808"))
    }

    private fun myAtoi(s: String): Int {
        var findNumber = false
        var negative = false
        var value = 0L
        for (c in s) {
            if (!findNumber && c == ' ') continue // 移除空格
            if (!findNumber) {
                if (c != '+' && c != '-' && c !in '0'..'9') {
                    return 0
                } else {
                    findNumber = true
                    negative = c == '-'
                    if (c in '0'..'9') value = (c - '0').toLong()
                }
            } else {
                if (c in '0'..'9') {
                    value = (value * 10) + (c - '0')
                    // 放在这里防止Long溢出
                    if (negative && (0L - value) <= Int.MIN_VALUE) {
                        return Int.MIN_VALUE
                    }
                    if (!negative && value >= Int.MAX_VALUE) {
                        return Int.MAX_VALUE
                    }
                } else {
                    break
                }
            }
        }
        return if (negative) -value.toInt() else value.toInt()
    }

    override fun link(): String {
        return "https://leetcode.com/problems/string-to-integer-atoi/"
    }

    override fun title(): String {
        return "String to Integer (atoi)"
    }

    override fun description(): String {
        return """把一个字符串转成一个32位整数，规则如下：
            * 忽略打头的空格
            * 如果碰到'+'或者'-'或者非0的数字则认为数字已经开始，否则认为不是数字
            * 碰到下一个非数字的字符则结束
            * 溢出默认取最值
        """.trimIndent()
    }

    override fun thinking(): String {
        return ""
    }
}