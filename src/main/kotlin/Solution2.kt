/**
 * create by yangliu on 2023/4/12
 * package name :
 */
class Solution2 : Solution() {
    override fun solve() {
        val l1 = createLinkedList(intArrayOf(2,4,3))
        val l2 = createLinkedList(intArrayOf(5,6,4))
        printLinkedList(addTwoNumbers(l1, l2))
    }

    private fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        val dummy = ListNode(-1)
        var tail = dummy
        var carry = 0
        var c1 = l1
        var c2 = l2
        while (c1 != null || c2 != null) {
            val num1 = c1?.`val` ?: 0
            val num2 = c2?.`val` ?: 0
            val sum = num1 + num2 + carry
            carry = sum / 10
            val node = ListNode(sum % 10)
            tail.next = node
            tail = node
            c1 = c1?.next
            c2 = c2?.next
        }
        if (carry != 0) {
            tail.next = ListNode(carry)
        }
        return dummy.next
    }

    override fun link(): String {
        return  "https://leetcode.com/problems/add-two-numbers/"
    }

    override fun title(): String {
        return "Add Two Numbers"
    }

    override fun description(): String {
        return """给出两个非空链表表示两个非空整数，数位逆序排列，求出表示这两个数之和的链表
            |注意：
            |* 你可以认为不存在 `0 -> 0 -> null` 这样的输入
        """.trimMargin()
    }

    override fun thinking(): String {
        return """
            从左到右依次相加，没什么难的
            时间复杂度 O(n) 空间复杂度 O(n)
        """.trimIndent()
    }
}