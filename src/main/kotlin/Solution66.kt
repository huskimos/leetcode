import java.util.*

/**
 * create by yangliu on 2023/5/29
 * package name :
 */
class Solution66 : Solution() {
    override fun solve() {
        println(plusOne(intArrayOf(1,2,3)).contentToString())
        println(plusOne(intArrayOf(4,3,2,1)).contentToString())
        println(plusOne(intArrayOf(9)).contentToString())
    }

    private fun plusOne(digits: IntArray): IntArray {
        val one = IntArray(digits.size) { 0 }
        one[one.size - 1] = 1
        val result = IntArray(digits.size + 1)
        var carry = 0
        for (i in digits.size - 1 downTo 0) {
            val sum = carry + digits[i] + one[i]
            result[i + 1] = sum % 10
            carry = sum / 10
        }
        if (carry != 0) {
            result[0] = carry
        }
        return if (result[0] != 0) result else result.copyOfRange(1, result.size)
    }

    override fun link(): String {
        return "https://leetcode.com/problems/plus-one/"
    }

    override fun title(): String {
        return "Plus One"
    }

    override fun description(): String {
        return "数组表示的整数加一"
    }

    override fun thinking(): String {
        return ""
    }
}