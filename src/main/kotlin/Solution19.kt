/**
 * create by yangliu on 2023/4/20
 * package name :
 */
class Solution19 : Solution() {
    override fun solve() {
        val head = createLinkedList(intArrayOf(1,2,3,4,5))
        printLinkedList(removeNthFromEnd(head, 1))
    }

    private fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        head ?: return null
        var fast = head
        var slow = head
        for (i in 1..n) {
            fast = fast?.next
        }
        if (fast == null) return head.next // 删除第一个节点
        while (fast?.next != null) {
            fast = fast.next
            slow = slow?.next
        }
        // 此时slow应该在倒数第n+1的节点处，即第n个节点的前一个节点
        val nNode = slow?.next
        slow?.next = nNode?.next
        nNode?.next = null
        return head
    }

    override fun link(): String {
        return "https://leetcode.com/problems/remove-nth-node-from-end-of-list/"
    }

    override fun title(): String {
        return "Remove Nth Node From End of List"
    }

    override fun description(): String {
        return """移除链表的的倒数第N个节点
            |注意1 <= n <= size
        """.trimMargin()
    }

    override fun thinking(): String {
        return "双指针"
    }
}