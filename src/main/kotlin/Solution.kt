import java.lang.StringBuilder
import java.util.*
import kotlin.collections.ArrayList

/**
 * create by yangliu on 2022/11/16
 * package name : leetcode
 */
fun IntArray.swap(i: Int, j: Int) {
    Objects.checkIndex(i, size)
    Objects.checkIndex(j, size)
    val temp = this[i]
    this[i] = this[j]
    this[j] = temp
}

fun CharArray.swap(i: Int, j: Int) {
    Objects.checkIndex(i, size)
    Objects.checkIndex(j, size)
    val temp = this[i]
    this[i] = this[j]
    this[j] = temp
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

interface Problem {
    fun link(): String
    fun title(): String
    fun description(): String
    fun thinking(): String
}

abstract class Solution : Problem {
    abstract fun solve()

    fun question(): String {
        return """******************************************************
            |链接: ${link()}
            |标题: ${title()}
            |描述: ${description()}
            |******************************************************
            |思路: 
            |${thinking()}
            |******************************************************""".trimMargin()
    }

    protected fun printLinkedList(head: ListNode?) {
        val sb = StringBuilder()
        var cur = head
        while (cur != null) {
            sb.append(cur.`val`)
            if (cur.next != null) {
                sb.append(" --> ")
            }
            cur = cur.next
        }
        println(sb.toString())
    }

    protected fun createLinkedList(nums: IntArray): ListNode? {
        if (nums.isNotEmpty()) {
            val head = ListNode(nums[0])
            var prev = head
            for (i in 1 until nums.size) {
                val node = ListNode(nums[i])
                prev.next = node
                prev = node
            }
            return head
        }
        return null
    }

    protected fun printBinaryTree(root: TreeNode?) {
        var result = arrayListOf<Int>()
        if (root != null) {
            val queue = LinkedList<TreeNode>()
            queue.addLast(root)
            while (queue.isNotEmpty()) {
                val current = queue.removeFirst()
                result.add(current.`val`)
                if (current.left != null) {
                    queue.addLast(current.left)
                }
                if (current.right != null) {
                    queue.addLast(current.right)
                }
            }
        }
        println(result.toArray().contentToString())
    }

    protected fun createBinaryTree(nums: Array<Int?>): TreeNode? {
        if (nums.isNotEmpty() && nums[0] != null) {
            val nodeList = ArrayList<TreeNode?>()
            val head = TreeNode(nums[0]!!)
            nodeList.add(head)
            for (i in 1 until nums.size) {
                val parent = (i - 1) / 2
                val node = if (nums[i] == null) null else TreeNode(nums[i]!!)
                if (i == 2 * parent + 1) {
                    // 左孩子
                    nodeList[parent]?.left = node
                } else {
                    // 右孩子
                    nodeList[parent]?.right = node
                }
                nodeList.add(node)
            }
            return head
        }
        return null
    }

    fun swap(nums: IntArray, i: Int, j: Int) {
        Objects.checkIndex(i, nums.size)
        Objects.checkIndex(j, nums.size)
        var temp = nums[i]
        nums[i] = nums[j]
        nums[j] = temp
    }

    fun swap(nums: CharArray, i: Int, j: Int) {
        Objects.checkIndex(i, nums.size)
        Objects.checkIndex(j, nums.size)
        var temp = nums[i]
        nums[i] = nums[j]
        nums[j] = temp
    }

    private fun IntArray.reverse(fromIndex: Int, toIndex: Int) {
        val midPoint = (fromIndex + toIndex) / 2
        if (fromIndex == midPoint) return
        var reverseIndex = toIndex - 1
        for (index in fromIndex until midPoint) {
            val tmp = this[index]
            this[index] = this[reverseIndex]
            this[reverseIndex] = tmp
            reverseIndex--
        }
    }
}

fun main() {
    val solution = Solution77()
    println(solution.question())
    solution.solve()
}