import java.util.*

/**
 * create by yangliu on 2023/5/29
 * package name :
 */
class Solution65 : Solution() {
    override fun solve() {
//        println(isNumber("0"))
//        println(isNumber("e"))
//        println(isNumber("."))
//        println(isNumber(".-"))
//        println(isNumber("+.9"))
        println(isNumber("4e+"))

//        println(isNumber("0089"))
//        println(isNumber("-0.1"))
//        println(isNumber("+3.14"))
//        println(isNumber("4."))
//        println(isNumber("-.9"))
//        println(isNumber("2e10"))
//        println(isNumber("-90E3"))
//        println(isNumber("3e+7"))
//        println(isNumber("+6e-1"))
//        println(isNumber("53.5e93"))
//        println(isNumber("-123.456e789"))

//        println(isNumber("abc"))
//        println(isNumber("1a"))
//        println(isNumber("1e"))
//        println(isNumber("e3"))
//        println(isNumber("99e2.5"))
//        println(isNumber("--6"))
//        println(isNumber("-+3"))
//        println(isNumber("95e54e53"))
    }

    private fun isNumber(s: String): Boolean {
        // 转成小写字符串，'E' -> 'e'
        return isNumber(
            s.toLowerCase(),
            allowEmpty = false,
            allowE = true,
            allowDot = true,
            allowFlag = true
        )
    }

    private fun isNumber(
        s: String,
        allowEmpty: Boolean,
        allowE: Boolean,
        allowDot: Boolean,
        allowFlag: Boolean
    ): Boolean {
        if (s.isEmpty()) return allowEmpty
        // e的处理
        val indexOfE = s.indexOf('e')
        if (indexOfE >= 0 && !allowE) return false
        if (indexOfE >= 0) {
            // 字符串中存在e
            return isNumber(
                s.substring(0, indexOfE),
                allowEmpty = false,
                allowE = false,
                allowDot = true,
                allowFlag = true
            ) && isNumber(
                s.substring(indexOfE + 1),
                allowEmpty = false,
                allowE = false,
                allowDot = false,
                allowFlag = true
            )
        }

        // 小数点的处理
        val indexOfDot = s.indexOf('.')
        if (indexOfDot >= 0 && !allowDot) return false
        if (indexOfDot == 0 && s.length == 1) return false
        if (indexOfDot >= 0) {
            // 字符串中存在小数点
            return isNumber(
                s.substring(0, indexOfDot),
                allowEmpty = true,
                allowE = true,
                allowDot = false,
                allowFlag = true
            ) && isNumber(
                s.substring(indexOfDot + 1),
                allowEmpty = true,
                allowE = true,
                allowDot = false,
                allowFlag = false
            )
        }

        // 字符串中不存在e和小数点
        for (i in s.indices) {
            if (s[i] != '+' && s[i] != '-' && s[i] !in '0'..'9') return false
            if ((s[i] == '+' || s[i] == '-') && (i != 0 || !allowFlag)) return false
        }
        return true
    }

    override fun link(): String {
        return "https://leetcode.com/problems/valid-number/"
    }

    override fun title(): String {
        return "Valid Number"
    }

    override fun description(): String {
        return "有效数字"
    }

    override fun thinking(): String {
        return ""
    }
}