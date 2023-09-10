/**
 * create by yangliu on 2023/9/10
 * package name :
 */
class Solution82 : Solution() {
    override fun solve() {
        printLinkedList(deleteDuplicates(createLinkedList(intArrayOf(1,2,3,3,4,4,5))))
    }

    private fun deleteDuplicates(head: ListNode?): ListNode? {
        val dummy = ListNode(-1)
        dummy.next = head
        var prev = dummy
        var current = head
        while (current != null) {
            if (current.`val` == current.next?.`val`) {
                // 出现重复元素
                while (current?.`val` == current?.next?.`val`) {
                    current = current?.next
                }
                // 删除值为current.val的节点
                prev.next = current?.next
            } else {
                prev = current
            }
            current = current?.next
        }
        return dummy.next
    }

    override fun link(): String {
        return "https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/"
    }

    override fun title(): String {
        return "Remove Duplicates from Sorted List II"
    }

    override fun description(): String {
        return "移除有序链表中的重复元素2，注意只要有重复，就应该从链表中删除，不用保留1个"
    }

    override fun thinking(): String {
        return ""
    }
}