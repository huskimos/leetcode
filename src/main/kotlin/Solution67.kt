import java.lang.StringBuilder
import java.util.*

/**
 * create by yangliu on 2023/5/29
 * package name :
 */
class Solution67 : Solution() {
    override fun solve() {
        println(addBinary("11", "1"))
        println(addBinary("1010", "1011"))
    }

    private fun addBinary(a: String, b: String): String {
        val result = arrayListOf<Char>()
        var carry = 0
        var charsA = a.toCharArray()
        var charsB = b.toCharArray()
        if (charsA.size < charsB.size) {
            val temp = CharArray(charsB.size) { '0' }
            System.arraycopy(charsA, 0, temp, charsB.size - charsA.size, charsA.size)
            charsA = temp
        } else if (charsB.size < charsA.size) {
            val temp = CharArray(charsA.size) { '0' }
            System.arraycopy(charsB, 0, temp, charsA.size - charsB.size, charsB.size)
            charsB = temp
        }
        for (i in charsA.size - 1 downTo 0) {
            val sum = (charsA[i] - '0') + (charsB[i] - '0') + carry
            result.add('0' + sum % 2)
            carry = sum / 2
        }
        if (carry != 0) result.add('0' + carry)
        val str = StringBuilder()
        for (i in result.size - 1 downTo 0) {
            str.append(result[i])
        }
        return str.toString()
    }

    override fun link(): String {
        return "https://leetcode.com/problems/add-binary/"
    }

    override fun title(): String {
        return "Add Binary"
    }

    override fun description(): String {
        return "二进制整数相加"
    }

    override fun thinking(): String {
        return ""
    }
}