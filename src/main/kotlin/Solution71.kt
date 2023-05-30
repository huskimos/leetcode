import java.lang.StringBuilder

/**
 * create by yangliu on 2023/5/30
 * package name :
 */
class Solution71 : Solution() {
    override fun solve() {
        println(simplifyPath("/home/"))
        println(simplifyPath("/../"))
        println(simplifyPath("/home//foo/"))
    }

    private fun simplifyPath(path: String): String {
        val parts = path.split('/').filter { it.isNotEmpty() }
        val result = arrayListOf<String>()
        for (dir in parts) {
            if (dir == ".") continue
            if (dir == "..") {
                if (result.isNotEmpty()) result.removeAt(result.lastIndex)
                continue
            }
            result.add(dir)
        }
        val sb = StringBuilder("/")
        for ((index, dir) in result.withIndex()) {
            sb.append(dir)
            if (index != result.size - 1) sb.append("/")
        }
        return sb.toString()
    }

    override fun link(): String {
        return "https://leetcode.com/problems/simplify-path/description/"
    }

    override fun title(): String {
        return "Simplify Path"
    }

    override fun description(): String {
        return """简化路径
            1. 以'/'打头
            2. 两个目录之间以单个'/'分隔
            3. 结尾没有'/'
            4. 没有相对路径'.'和'..'
        """.trimIndent()
    }

    override fun thinking(): String {
        return ""
    }
}