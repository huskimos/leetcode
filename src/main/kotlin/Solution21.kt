/**
 * create by yangliu on 2023/4/22
 * package name :
 */
class Solution21 : Solution() {
    override fun solve() {
        val list1 = createLinkedList(intArrayOf(1,2,4))
        val list2 = createLinkedList(intArrayOf(1,3,4))
        printLinkedList(mergeTwoLists(list1, list2))
    }

    private fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        if (list1 == null && list2 == null) return null
        if (list1 == null) return list2
        if (list2 == null) return list1
        var p1 = list1
        var p2 = list2
        val dummy = ListNode(-1)
        var tail = dummy
        while (p1 != null || p2 != null) {
            if (p1 == null) {
                // 取p2
                val next = p2!!.next
                tail.next = p2
                tail = p2
                p2.next = null
                p2 = next
            } else if (p2 == null) {
                // 取p1
                val next = p1.next
                tail.next = p1
                tail = p1
                p1.next = null
                p1 = next
            } else if (p1.`val` <= p2.`val`) {
                // 取p1
                val next = p1.next
                tail.next = p1
                tail = p1
                p1.next = null
                p1 = next
            } else {
                // 取p2
                val next = p2.next
                tail.next = p2
                tail = p2
                p2.next = null
                p2 = next
            }
        }
        return dummy.next
    }

    override fun link(): String {
        return "https://leetcode.com/problems/merge-two-sorted-lists/"
    }

    override fun title(): String {
        return "Merge Two Sorted Lists"
    }

    override fun description(): String {
        return "合并联合有序链表"
    }

    override fun thinking(): String {
        return "类似于归并排序的归并过程"
    }
}