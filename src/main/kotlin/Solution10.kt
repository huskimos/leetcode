/**
 * create by yangliu on 2023/4/14
 * package name :
 */
class Solution10 : Solution() {
    override fun solve() {
//        println(isMatch("aa", "a"))
//        println(isMatch("aa", "a*"))
//        println(isMatch("ab", ".*"))
//        println(isMatch("cdddabd", "c.*d"))
        println(isMatch("a", ".*..a*"))
    }

    private fun isMatch(s: String, p: String): Boolean {
        return isMatch(s, 0, p, 0)
    }

    private fun isMatch(s: String, sIndex: Int, p: String, pIndex: Int): Boolean {
        if (pIndex >= p.length) return sIndex >= s.length
        if (pIndex == p.length - 1) {
            // 模式只剩下最后一个字符，因为模式一定有效，则模式的最后一个字符不会是'*'
            // 应该匹配单个字符
            return if (sIndex == s.length - 1) {
                p[pIndex] == '.' || p[pIndex] == s[sIndex]
            } else {
                false
            }
        }
        // 模式字符串还有不止两个字符，只需要最多再往下看两个字符
        if (p[pIndex + 1] == '*') {
            // 可能有多个匹配 p*pppa
            val prev = p[pIndex]
            // 可以选择匹配0个prev
            if (isMatch(s, sIndex, p, pIndex + 2)) {
                return true
            }
            // 至少匹配一个prev,可以从头匹配到直到第一个不是prev的子串
            for (i in sIndex until s.length) {
                if (s[i] == prev || prev == '.') {
                    // 检查剩下的子串
                    if (isMatch(s, i + 1, p, pIndex + 2)) {
                        return true
                    }
                } else {
                    // 不再匹配prev
                    return isMatch(s, i, p, pIndex + 2)
                }
            }
        } else {
            return if (sIndex < s.length && (p[pIndex] == '.' || p[pIndex] == s[sIndex])) {
                // 递归，单个字符匹配，注意一定要判断sIndex < s.length
                isMatch(s, sIndex + 1, p, pIndex + 1)
            } else {
                false
            }
        }
        return false
    }

    override fun link(): String {
        return "https://leetcode.com/problems/regular-expression-matching/"
    }

    override fun title(): String {
        return "Regular Expression Matching"
    }

    override fun description(): String {
        return """正则表达式匹配
            '.'匹配任意单个字符
            '*'匹配0个或多个先前的字符
            给出的模式一定是合法的
            字符串中只包含'.', '*'和英文小写字母
        """.trimIndent()
    }

    override fun thinking(): String {
        return """
            * 每次读取pattern的一个字符
            * 每个字符读出来都需要考虑后一个字符，两个字符才能确定当前的模式子串该如何匹配
            * 根据当前的匹配规则，对target打头的子串进行匹配
            * 对于每一个可以匹配的前缀，它后续的子串和子模式进行迭代判断
        """.trimIndent()
    }
}