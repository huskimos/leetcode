/**
 * create by yangliu on 2023/5/27
 * package name :
 */
class Solution61 : Solution() {
    override fun solve() {
        printLinkedList(rotateRight(createLinkedList(intArrayOf(1,2,3,4,5)), 2))
    }

    private fun rotateRight(head: ListNode?, k: Int): ListNode? {
        // 求得链表的长度
        var current = head
        var len = 0
        while (current != null) {
            current = current.next
            len++
        }
        // 如果链表为null
        if (len == 0) return null
        // 求出旋转偏移
        val offset = k % len
        // 如果偏移为0
        if (offset == 0) return head
        // 找到倒数第offset个节点
        var slowPrev: ListNode? = null
        var tail: ListNode? = null
        var slow = head
        var fast = head
        var index = 0
        while (index < offset && fast != null) {
            fast = fast.next
            index++
        }
        while (fast != null) {
            val next = fast.next
            if (next == null) tail = fast
            fast = next
            slowPrev = slow
            slow = slow?.next
        }
        tail?.next = head
        slowPrev?.next = null
        return slow
    }

    override fun link(): String {
        return "https://leetcode.com/problems/rotate-list/"
    }

    override fun title(): String {
        return "Rotate List"
    }

    override fun description(): String {
        return "向右旋转链表"
    }

    override fun thinking(): String {
        return "快慢指针"
    }
}