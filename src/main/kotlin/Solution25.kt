/**
 * create by yangliu on 2023/4/23
 * package name :
 */
class Solution25 : Solution() {
    override fun solve() {
        printLinkedList(reverseKGroup(createLinkedList(intArrayOf(1,2,3,4,5)), 3))
    }

    private fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
        head ?: return null
        var current = head
        var index = 0
        while (current != null && index < k) {
            current = current.next
            index++
        }
        if (index < k) return head // 不足k节点，不逆转
        val dummy = ListNode(-1)
        index = 0
        current = head
        while (index < k && current != null) {
            // 头插
            val next = current.next
            current.next = dummy.next
            dummy.next = current
            current = next
            index++
        }
        head.next = reverseKGroup(current, k)
        return dummy.next
    }

    override fun link(): String {
        return "Reverse Nodes in k-Group"
    }

    override fun title(): String {
        return "Reverse Nodes in k-Group"
    }

    override fun description(): String {
        return "K个一组交换链表"
    }

    override fun thinking(): String {
        return "递归"
    }
}