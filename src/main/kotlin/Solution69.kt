/**
 * create by yangliu on 2023/5/29
 * package name :
 */
class Solution69 : Solution() {
    override fun solve() {
        println(mySqrt(4))
    }

    private fun mySqrt(x: Int): Int {
        for (i in 0..x / 2) {
            if (i.toLong() * i <= x && (i.toLong() + 1) * (i + 1) > x) {
                return i
            }
        }
        return x
    }

    override fun link(): String {
        return "https://leetcode.com/problems/sqrtx/"
    }

    override fun title(): String {
        return "Sqrt(x)"
    }

    override fun description(): String {
        return "实现开平方"
    }

    override fun thinking(): String {
        return ""
    }
}