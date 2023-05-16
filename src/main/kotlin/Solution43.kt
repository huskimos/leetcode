import java.lang.StringBuilder

/**
 * create by yangliu on 2023/5/16
 * package name :
 */
class Solution43 : Solution() {
    override fun solve() {
        println(multiply("2", "3"))
        println(multiply("0", "0"))
        println(multiply("1000", "345"))
        println(multiply("123", "456"))
        println(multiply("999", "999"))
        println(multiply("999", "99"))
    }

    private fun multiply(num1: String, num2: String): String {
        assert(num1.isNotEmpty() && num2.isNotEmpty())
        val len = num1.length + num2.length
        // 1. 求每一位的乘积
        val temp1 = Array(num2.length) { IntArray(len) { 0 } }
        for (i in num2.length - 1 downTo 0) {
            var carry = 0
            for (j in num1.length - 1 downTo 0) {
                val multi = (num2[i] - '0') * (num1[j] - '0') + carry
                temp1[i][i + j + 1] = multi % 10
                carry = multi / 10
            }
            if (carry != 0) {
                temp1[i][i] = carry
            }
        }
        // 2. 把每一位的乘积相加
        val temp2 = ArrayList<Char>()
        var carry = 0
        for (j in len - 1 downTo 0) {
            var sum = carry
            for (i in temp1.indices) {
                sum += temp1[i][j]
            }
            temp2.add('0' + sum % 10)
            carry = sum / 10
        }
        // 3. 去除末尾的0，组合成结果
        val result = StringBuilder()
        var valid = false
        for (i in len - 1 downTo 0) {
            if (temp2[i] != '0' || valid) {
                valid = true
                result.append(temp2[i])
            }
        }
        // 4. 判断乘积是否是0
        return if (result.isBlank()) "0" else result.toString()
    }

    override fun link(): String {
        return "https://leetcode.com/problems/multiply-strings/"
    }

    override fun title(): String {
        return "Multiply Strings"
    }

    override fun description(): String {
        return "字符串表示的整数相乘"
    }

    override fun thinking(): String {
        return ""
    }
}