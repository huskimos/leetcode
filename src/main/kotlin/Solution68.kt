import java.lang.StringBuilder

/**
 * create by yangliu on 2023/5/29
 * package name :
 */
class Solution68 : Solution() {
    override fun solve() {
        val words = arrayOf("This", "is", "an", "example", "of", "text", "justification.")
        val words1 = arrayOf("Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do")
        println(fullJustify(words, 16))
    }

    /**
     * 注意最后一行的处理
     */
    private fun fullJustify(words: Array<String>, maxWidth: Int): List<String> {
        var index = 0
        val result = arrayListOf<String>()
        val lineWords = arrayListOf<String>()
        var lineWidthWithSpace = 0
        var lineWidthWithoutSpace = 0
        while (index < words.size) {
            if (lineWidthWithSpace != 0) lineWidthWithSpace += 1
            lineWidthWithSpace += words[index].length
            if (lineWidthWithSpace <= maxWidth) {
                lineWords.add(words[index])
                lineWidthWithoutSpace += words[index].length
                index++
                continue
            }
            // 得到一行
            val line = constructLine(lineWords, lineWidthWithoutSpace, maxWidth)
            result.add(line)
            lineWords.clear()
            lineWidthWithSpace = 0
            lineWidthWithoutSpace = 0
        }
        // 最后一行
        val line = StringBuilder()
        for (i in lineWords.indices) {
            line.append(lineWords[i])
            if (i != lineWords.size - 1) {
                line.append(" ")
            }
        }
        val totalSpace = maxWidth - lineWidthWithSpace
        for (i in 1..totalSpace) {
            line.append(" ")
        }
        result.add(line.toString())
        return result
    }

    private fun constructLine(lineWords: List<String>, wordLength: Int, maxWidth: Int): String {
        val line = StringBuilder()
        if (lineWords.size == 1) {
            // 只有一个单词
            val totalSpace = maxWidth - wordLength
            line.append(lineWords[0])
            for (i in 1..totalSpace) {
                line.append(" ")
            }
        } else {
            val totalSpace = maxWidth - wordLength
            val space = totalSpace / (lineWords.size - 1)
            val largerSpaceCount = totalSpace % (lineWords.size - 1)
            for (i in lineWords.indices) {
                line.append(lineWords[i])
                if (i < largerSpaceCount) {
                    for (j in 1..space + 1) {
                        line.append(" ")
                    }
                } else if (i != lineWords.size - 1){
                    for (j in 1..space) {
                        line.append(" ")
                    }
                }
            }
        }
        return line.toString()
    }

    override fun link(): String {
        return "https://leetcode.com/problems/text-justification/"
    }

    override fun title(): String {
        return "Text Justification"
    }

    override fun description(): String {
        return "按照最大宽度调整文本"
    }

    override fun thinking(): String {
        return ""
    }
}